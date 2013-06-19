/**
 *
 * 
 */

package org.apache.cassandra.db;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.cassandra.db.filter.QueryFilter;
import org.apache.cassandra.db.filter.QueryPath;
import org.apache.cassandra.db.marshal.AbstractType;
import org.apache.cassandra.db.marshal.LongType;
import org.apache.cassandra.io.IColumnSerializer;
import org.apache.cassandra.io.util.DataOutputBuffer;
import org.apache.cassandra.io.util.IIterableColumns;
import org.apache.cassandra.service.StorageService;
import org.apache.cassandra.thrift.ColumnPath;
import org.apache.cassandra.utils.Allocator;
import org.apache.cassandra.utils.ByteBufferUtil;
import org.apache.cassandra.utils.HeapAllocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A column that represents a partitioned columns.
 */
public class UpdateColumn extends Column implements IColumnContainer,
		IIterableColumns {
	private static Logger logger = LoggerFactory.getLogger(UpdateColumn.class);
	private final int versionCount;
	private final boolean isDelta;
	private ISortedColumns columns;
	private MergeColumn mc;

	public UpdateColumn(ByteBuffer name, ByteBuffer value, long timestamp,
			long version) {
		this(name, value, timestamp, version, 0, true, null);
	}

	public UpdateColumn(ByteBuffer name, ByteBuffer value, long timestamp,
			long version, int versionCount, boolean isDelta,
			ISortedColumns columns) {
		super(name, value, timestamp, version);
		this.versionCount = versionCount;
		this.isDelta = isDelta;
		if (columns == null) {
			this.columns = createSortedColumns();
		} else {
			this.columns = columns;
		}
	}

	public static UpdateColumn create(ByteBuffer name, ByteBuffer value,
			long timestamp, long version, int versionCount, boolean isDelta,
			ISortedColumns columns, IColumnSerializer.Flag flag) {
		// #elt being negative means we have to clean delta
		// short count = value.getShort(value.position());
		// if (flag == IColumnSerializer.Flag.FROM_REMOTE
		// || (flag == IColumnSerializer.Flag.LOCAL && count < 0))
		// value = CounterContext.instance().clearAllDelta(value);
		return new UpdateColumn(name, value, timestamp, version, versionCount,
				isDelta, columns);
	}

	public static ISortedColumns createSortedColumns() {
		return createSortedColumns(LongType.instance, TreeMapDeltaSortedColumns
				.factory(), false);
	}

	public static ISortedColumns createSortedColumns(
			AbstractType<?> comparator, ISortedColumns.Factory factory,
			boolean reversedInsertOrder) {
		return factory.create(comparator, reversedInsertOrder);
	}

	public int versionCount() {
		return versionCount;

	}

	public boolean isDelta() {
		return isDelta;

	}

	@Override
	public int size() {
		/*
		 * A update column adds to a Column : + 8 bytes for version
		 */
		return (super.size() + DBConstants.intSize + DBConstants.intSize + DBConstants.boolSize)
				* (getColumnCount() + 1);
	}

	@Override
	public void updateDigest(MessageDigest digest) {
		digest.update(name.duplicate());
		digest.update(value.duplicate());

		DataOutputBuffer buffer = new DataOutputBuffer();
		try {
			buffer.writeLong(timestamp);
			buffer.writeByte(serializationFlags());
			buffer.writeLong(version);
			buffer.writeInt(versionCount);
			buffer.writeBoolean(isDelta);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		digest.update(buffer.getData(), 0, buffer.getLength());
	}

	@Override
	public IColumn reconcile(IColumn column, Allocator allocator) {
		if (column.isMarkedForDelete() || timestamp() != column.timestamp()) { // live
			// +
			// tombstone
			return timestamp() < column.timestamp() ? column : this;
		} else {
			mc = new MergeColumn(deltadata);
			if (column instanceof UpdateColumn) {
				if (version() == -1) {
					return mc.mergeDisOrderColumn(column, this,
							((UpdateColumn) column).columns());
				} else if (column.version() == -1) {
					return mc.mergeDisOrderColumn(this, column, columns());
				}
				if (((UpdateColumn) column).getColumnCount() == 0) {
					if (getColumnCount() == 0) {
						return oneToOneUpdateColumn(this,
								(UpdateColumn) column, allocator);
					} else {
						return manyToOneUpdateColumn(this,
								(UpdateColumn) column, allocator);
					}

				} else {
					if (getColumnCount() == 0) {
						return oneNewToManyOld(column, allocator);
					} else {
						return manyNewToManyOld(column, allocator);
					}
				}
			} else {
				if (version() == -1) {
					return mc.mergeDisOrderColumn(column, this, null);
				}
				if (getColumnCount() == 0) {
					return oneToOneColumn(this, column, allocator);
				} else {
					return manyToOneColumn(this, column, allocator);
				}
			}
		}

	}

	private IColumn oneToOneUpdateColumn(UpdateColumn newcolumn,
			UpdateColumn column, Allocator allocator) {

		if (column.version() == (newcolumn.version() - newcolumn.versionCount() - 1)) {
			return mc.mergeOrderColumn(column, newcolumn, newcolumn.columns());
		} else if (column.version() == (newcolumn.version()
				+ column.versionCount() + 1)) {
			return mc.mergeOrderColumn(newcolumn, column, newcolumn.columns());
		} else if (column.version() < (newcolumn.version()
				- newcolumn.versionCount() - 1)) {
			column.columns().addColumn(newcolumn, allocator);
			return column;
		} else if (newcolumn.version() < (column.version()
				- column.versionCount() - 1)) {
			newcolumn.columns().addColumn(column, allocator);
			return newcolumn;
		} else if (newcolumn.version() == column.version()) {
			if (newcolumn.versionCount() == 0 && column.versionCount() == 0) {
				return newcolumn.value().compareTo(column.value()) < 0 ? newcolumn
						: column;
			}
		}

		return column;
	}

	private IColumn oneToOneColumn(UpdateColumn newcolumn, IColumn column,
			Allocator allocator) {

		if (newcolumn.version() - newcolumn.versionCount() == column.version() + 1) {
			return mc.mergeOrderColumn(column, newcolumn, null);
		} else if (newcolumn.version() - newcolumn.versionCount() > column
				.version() + 1) {
			ISortedColumns columns = createSortedColumns();
			columns.addColumn(newcolumn, allocator);
			return mc.newColumn(newcolumn.name(), column.value(), column
					.timestamp(), column.version(), 0, false, columns, column
					.getObjValue());
		}
		return column;
	}

	private IColumn oneNewToManyOld(IColumn column, Allocator allocator) {

		return manyToOneUpdateColumn((UpdateColumn) column, this, allocator);
	}

	private IColumn manyNewToManyOld(IColumn column, Allocator allocator) {
		for (IColumn tempcolumn : getSortedColumns()) {
			column = manyToManyUpdateColumn((UpdateColumn) tempcolumn, column,
					allocator);
		}
		columns().clear();
		if (column instanceof UpdateColumn) {
			if (((UpdateColumn) column).getColumnCount() == 0) {
				if (isDelta() == false) {
					return oneToOneColumn((UpdateColumn) column, (Column) this,
							allocator);
				} else {
					return oneToOneUpdateColumn((UpdateColumn) column,
							(UpdateColumn) this, allocator);
				}
			} else {
				if (isDelta() == false) {
					return manyToOneColumn((UpdateColumn) column,
							(Column) this, allocator);
				} else {
					return manyToOneUpdateColumn((UpdateColumn) column,
							(UpdateColumn) this, allocator);
				}
			}
		} else {
			if (isDelta() == false) {
				if (version > column.version()) {
					return this;
				}
			} else {
				return oneToOneColumn((UpdateColumn) this, (Column) column,
						allocator);
			}
		}
		return column;

	}

	private IColumn manyToManyUpdateColumn(UpdateColumn newcolumn,
			IColumn column, Allocator allocator) {
		if (column instanceof UpdateColumn) {
			if (((UpdateColumn) column).getColumnCount() == 0) {
				return oneToOneUpdateColumn((UpdateColumn) column, newcolumn,
						allocator);
			} else {
				return manyToOneUpdateColumn((UpdateColumn) column, newcolumn,
						allocator);
			}
		} else {
			return oneToOneColumn(newcolumn, (Column) column, allocator);
		}

	}

	private IColumn manyToOneUpdateColumn(UpdateColumn newcolumn,
			UpdateColumn column, Allocator allocator) {
		if (column.version() <= newcolumn.version()) {
			if (newcolumn.isDelta() == false) {
				return newcolumn;
			} else {
				if (column.version() == newcolumn.version()
						- newcolumn.versionCount() - 1) {
					return mc.mergeOrderColumn(column, newcolumn, newcolumn
							.columns());
				} else if (column.version() < newcolumn.version()
						- newcolumn.versionCount() - 1) {
					newcolumn.columns().addColumn(
							mc.newColumn(newcolumn.name(), newcolumn.value(),
									newcolumn.timestamp(), newcolumn.version(),
									newcolumn.versionCount(), newcolumn
											.isDelta(), null, newcolumn
											.getObjValue()), allocator);
					return mc.newColumn(column.name(), column.value(), column
							.timestamp(), column.version(), column
							.versionCount(), column.isDelta(), newcolumn
							.columns(), column.getObjValue());
				}
			}
		} else if (newcolumn.version() == column.version()
				- column.versionCount() - 1) {
			UpdateColumn firstcolumn = (UpdateColumn) newcolumn.columns()
					.getColumn(newcolumn.columns().getColumnNames().first());
			if (column.version() == firstcolumn.version()
					- firstcolumn.versionCount() - 1) {
				if (newcolumn.getColumnCount() == 1) {
					if (newcolumn.isDelta() == false) {
						return mc.mergeOrderColumn(newcolumn, column,
								firstcolumn, null);
					} else {
						return mc.mergeOrderColumn(newcolumn, column,
								firstcolumn, column.columns());
					}
				} else {
					newcolumn.columns().removeColumn(
							newcolumn.columns().getColumnNames().first());
					return mc.mergeOrderColumn(newcolumn, column, firstcolumn,
							newcolumn.columns());
				}
			} else if (column.version() < firstcolumn.version()
					- firstcolumn.versionCount() - 1) {
				return mc.mergeOrderColumn(newcolumn, column, newcolumn
						.columns());
			}
		} else if (newcolumn.version() < column.version()
				- column.versionCount() - 1) {
			UpdateColumn frontcolumn = null;
			UpdateColumn backcolumn = null;
			ByteBuffer frontkey = (ByteBuffer) ((NavigableSet) newcolumn
					.columns().getColumnNames()).floor(ByteBufferUtil
					.bytes(column.version()));
			ByteBuffer backkey = (ByteBuffer) ((NavigableSet) newcolumn
					.columns().getColumnNames()).higher(ByteBufferUtil
					.bytes(column.version()));
			if (frontkey != null) {
				frontcolumn = (UpdateColumn) newcolumn.columns().getColumn(
						frontkey);
			}
			if (backkey != null) {
				backcolumn = (UpdateColumn) newcolumn.columns().getColumn(
						backkey);
			}
			if (frontcolumn == null) {
				if (column.version() == backcolumn.version()
						- backcolumn.versionCount() - 1) {
					frontcolumn = (UpdateColumn) mc.mergeOrderColumn(column,
							backcolumn, backcolumn.columns());
					newcolumn.columns().addColumn(frontcolumn, allocator);
				} else {
					newcolumn.columns().addColumn(column, allocator);
				}
				return newcolumn;

			} else if (backcolumn == null) {
				if (frontcolumn.version() == column.version()
						- column.versionCount() - 1) {
					backcolumn = (UpdateColumn) mc.mergeOrderColumn(
							frontcolumn, column, column.columns());
					newcolumn.columns().addColumn(backcolumn, allocator);
					newcolumn.columns().removeColumn(frontkey);
				} else {
					newcolumn.columns().addColumn(column, allocator);
				}
				return newcolumn;
			} else {
				if (frontcolumn.version() == column.version()
						- column.versionCount() - 1) {
					if (column.version() == backcolumn.version()
							- backcolumn.versionCount() - 1) {
						backcolumn = (UpdateColumn) mc.mergeOrderColumn(
								frontcolumn, column, backcolumn, backcolumn
										.columns());
					} else {
						backcolumn = (UpdateColumn) mc.mergeOrderColumn(
								frontcolumn, column, column.columns());
					}
					newcolumn.columns().addColumn(backcolumn, allocator);
					newcolumn.columns().removeColumn(frontkey);
					return newcolumn;

				} else {
					if (column.version() == backcolumn.version()
							- backcolumn.versionCount() - 1) {
						backcolumn = (UpdateColumn) mc.mergeOrderColumn(column,
								backcolumn, backcolumn.columns());
						newcolumn.columns().addColumn(backcolumn, allocator);
						newcolumn.columns().removeColumn(frontkey);
					} else {
						newcolumn.columns().addColumn(column, allocator);
					}
					return newcolumn;
				}
			}

		}
		return column;
	}

	private IColumn manyToOneColumn(UpdateColumn newcolumn, IColumn column,
			Allocator allocator) {
		if (column.version() <= newcolumn.version()) {
			if (newcolumn.isDelta() == false) {
				return newcolumn;
			} else {
				if (column.version() == newcolumn.version()
						- newcolumn.versionCount() - 1) {
					return mc.mergeOrderColumn(column, newcolumn, newcolumn
							.columns());
				} else if (column.version() < newcolumn.version()
						- newcolumn.versionCount() - 1) {
					newcolumn.columns().addColumn(
							mc.newColumn(newcolumn.name(), newcolumn.value(),
									newcolumn.timestamp(), newcolumn.version(),
									newcolumn.versionCount(), newcolumn
											.isDelta(), null,
									newcolumn.objValue), allocator);
					return mc.newColumn(column.name(), column.value(), column
							.timestamp(), column.version(), 0, false, newcolumn
							.columns(), column.getObjValue());
				}
			}
		} else if (newcolumn.version() == column.version() - 1) {
			UpdateColumn firstcolumn = (UpdateColumn) newcolumn.columns()
					.getColumn(newcolumn.columns().getColumnNames().first());
			if (column.version() == firstcolumn.version()
					- firstcolumn.versionCount() - 1) {
				if (newcolumn.getColumnCount() == 1) {
					return mc.mergeOrderColumn(column, firstcolumn, null);
				} else {
					newcolumn.columns().removeColumn(
							newcolumn.columns().getColumnNames().first());
					return mc.mergeOrderColumn(column, firstcolumn, newcolumn
							.columns());
				}
			} else if (column.version() < firstcolumn.version()
					- firstcolumn.versionCount() - 1) {
				return mc.newColumn(column.name(), column.value(), column
						.timestamp(), column.version(), 0, false, newcolumn
						.columns(), column.getObjValue());
			}
		} else if (newcolumn.version() < column.version() - 1) {
			UpdateColumn backcolumn = null;
			ByteBuffer backkey = (ByteBuffer) ((NavigableSet) newcolumn
					.columns().getColumnNames()).higher(ByteBufferUtil
					.bytes(column.version()));
			if (backkey != null) {
				backcolumn = (UpdateColumn) newcolumn.columns().getColumn(
						backkey);
			}
			if (backcolumn == null) {
				return column;
			} else {
				if (column.version() == backcolumn.version()
						- backcolumn.versionCount() - 1) {
					newcolumn.columns().tailColumn(backkey, false);
					if (newcolumn.getColumnCount() == 0) {
						return mc.mergeOrderColumn(column, backcolumn, null);
					} else {
						return mc.mergeOrderColumn(column, backcolumn,
								newcolumn.columns());
					}
				} else {
					newcolumn.columns().tailColumn(backkey, true);
					return mc.newColumn(column.name(), column.value(), column
							.timestamp(), column.version(), 0, false, newcolumn
							.columns(), column.getObjValue());
				}
			}
		}
		return column;
	}

	public ISortedColumns columns() {
		return columns;
	}

	@Override
	public IColumn localCopy(ColumnFamilyStore cfs) {
		mc = new MergeColumn(cfs.metadata.deltadata);
		return mc.newColumn(cfs.internOrCopy(name, HeapAllocator.instance),
				ByteBufferUtil.clone(value), timestamp, version, versionCount,
				isDelta, columns, objValue);
	}

	@Override
	public IColumn localCopy(ColumnFamilyStore cfs, Allocator allocator) {
		mc = new MergeColumn(cfs.metadata.deltadata);
		return mc.newColumn(cfs.internOrCopy(name, allocator), allocator
				.clone(value), timestamp, version, versionCount, isDelta,
				columns, objValue);
	}

	public IColumn readSSTableColumn(ByteBuffer key, ColumnFamilyStore cfs) {

		ColumnPath column_path = new ColumnPath(cfs.columnFamily);
		column_path.setColumn(name);
		QueryPath path = new QueryPath(column_path.column_family,
				column_path.column == null ? null : column_path.super_column);
		SortedSet<ByteBuffer> columnNames = new TreeSet<ByteBuffer>();
		columnNames.addAll(Arrays
				.asList(column_path.column == null ? column_path.super_column
						: column_path.column));
		DecoratedKey<?> dk = StorageService.getPartitioner().decorateKey(key);

		try {
			logger.debug("get");
			QueryFilter filter = QueryFilter.getNamesFilter(dk, path,
					columnNames);
			ColumnFamilyStore cfStore = cfs.table.getColumnFamilyStore(filter
					.getColumnFamilyName());
			ColumnFamily columnFamily = cfStore.getColumnFamily(filter,
					ArrayBackedSortedColumns.factory());
			if (columnFamily == null || columnFamily.getColumnCount() == 0) {
				return null;
			}
			IColumn sstable_column = (Column) columnFamily.getColumn(name);
			mc = new MergeColumn(cfs.metadata.deltadata);
			if (sstable_column instanceof UpdateColumn) {

				return mc.newColumn(name, sstable_column.value(),
						sstable_column.timestamp(), sstable_column.version(),
						((UpdateColumn) sstable_column).versionCount(),
						((UpdateColumn) sstable_column).isDelta(),
						((UpdateColumn) sstable_column).columns(),
						sstable_column.getObjValue());

			} else {
				return mc.newColumn(name, sstable_column.value(),
						sstable_column.timestamp(), sstable_column.version(),
						sstable_column.getObjValue());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int serializationFlags() {
		return ColumnSerializer.UPDATE_MASK;
	}

	@Override
	public AbstractType getComparator() {
		return columns.getComparator();
	}

	@Override
	public Collection<IColumn> getSortedColumns() {
		return columns.getSortedColumns();
	}

	@Override
	public void remove(ByteBuffer columnName) {
		columns.removeColumn(columnName);
	}

	@Override
	public boolean replace(IColumn oldColumn, IColumn newColumn) {
		return columns.replace(oldColumn, newColumn);
	}

	@Override
	public int getEstimatedColumnCount() {
		return getColumnCount();
	}

	public int getColumnCount() {
		return columns.size();
	}

	@Override
	public Iterator<IColumn> iterator() {
		return columns.iterator();
	}

}
