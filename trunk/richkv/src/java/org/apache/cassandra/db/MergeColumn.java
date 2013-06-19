package org.apache.cassandra.db;

import java.nio.ByteBuffer;

import org.apache.cassandra.utils.app.AppCase;
import org.apache.cassandra.utils.app.ConvertData;
import org.apache.cassandra.utils.app.DeltaData;

public class MergeColumn {

	public DeltaData deltadata;

	public MergeColumn(DeltaData deltadata) {
		this.deltadata = deltadata;
	}

	public IColumn newColumn(ByteBuffer name, ByteBuffer value, long timestamp,
			long version) {
		IColumn column = new Column(name, value, timestamp, version);
		column.setDeltaData(deltadata);
		return column;
	}

	public IColumn newColumn(ByteBuffer name, ByteBuffer value, long timestamp,
			long version, int versionCount, boolean isDelta,
			ISortedColumns columns) {

		IColumn column = new UpdateColumn(name, value, timestamp, version,
				versionCount, isDelta, columns);
		column.setDeltaData(deltadata);
		return column;

	}

	public IColumn newColumn(ByteBuffer name, ByteBuffer value, long timestamp,
			long version, Object obj) {
		IColumn column = new Column(name, value, timestamp, version);
		column.setDeltaData(deltadata);
		column.setObjValue(obj);
		return column;
	}

	public IColumn newColumn(ByteBuffer name, ByteBuffer value, long timestamp,
			long version, int versionCount, boolean isDelta,
			ISortedColumns columns, Object obj) {

		IColumn column = new UpdateColumn(name, value, timestamp, version,
				versionCount, isDelta, columns);
		column.setDeltaData(deltadata);
		column.setObjValue(obj);
		return column;

	}

	public IColumn mergeDisOrderColumn(IColumn firstcolumn, IColumn lastcolumn,
			ISortedColumns columns) {
		if (columns != null) {
			return newColumn(firstcolumn.name(), null, firstcolumn.timestamp(),
					firstcolumn.version(), ((UpdateColumn) firstcolumn)
							.versionCount(), ((UpdateColumn) firstcolumn)
							.isDelta(), columns, invoke(firstcolumn,
							lastcolumn, ((UpdateColumn) firstcolumn).isDelta()));
		} else {
			return newColumn(firstcolumn.name(), null, firstcolumn.timestamp(),
					firstcolumn.version(), invoke(firstcolumn, lastcolumn,
							false));
		}
	}

	public IColumn mergeOrderColumn(IColumn firstcolumn, IColumn lastcolumn,
			ISortedColumns columns) {
		if (firstcolumn instanceof UpdateColumn) {
			return newColumn(firstcolumn.name(), null, firstcolumn.timestamp(),
					lastcolumn.version(), ((UpdateColumn) firstcolumn)
							.versionCount()
							+ ((UpdateColumn) lastcolumn).versionCount() + 1,
					((UpdateColumn) firstcolumn).isDelta(), columns, invoke(
							firstcolumn, lastcolumn,
							((UpdateColumn) firstcolumn).isDelta()));
		} else {
			if (columns == null) {
				return newColumn(firstcolumn.name(), null, firstcolumn
						.timestamp(), lastcolumn.version(), invoke(firstcolumn,
						lastcolumn, false));
			} else {
				return newColumn(firstcolumn.name(), null, firstcolumn
						.timestamp(), lastcolumn.version(),
						((UpdateColumn) lastcolumn).versionCount() + 1, false,
						columns, invoke(firstcolumn, lastcolumn, false));
			}
		}
	}

	public IColumn mergeOrderColumn(IColumn firstcolumn, IColumn middlecolumn,
			IColumn lastcolumn, ISortedColumns columns) {
		if (firstcolumn instanceof UpdateColumn) {
			if (columns == null) {
				return newColumn(firstcolumn.name(), null, firstcolumn
						.timestamp(), lastcolumn.version(), invoke(invoke(
						firstcolumn, middlecolumn, false), lastcolumn, false));
			}
			return newColumn(firstcolumn.name(), null, firstcolumn.timestamp(),
					lastcolumn.version(), ((UpdateColumn) firstcolumn)
							.versionCount()
							+ ((UpdateColumn) middlecolumn).versionCount()
							+ ((UpdateColumn) lastcolumn).versionCount() + 2,
					((UpdateColumn) firstcolumn).isDelta(), columns, invoke(
							invoke(firstcolumn, middlecolumn,
									((UpdateColumn) firstcolumn).isDelta()),
							lastcolumn, ((UpdateColumn) firstcolumn).isDelta()));
		} else {
			return newColumn(firstcolumn.name(), null, firstcolumn.timestamp(),
					lastcolumn.version(), invoke(invoke(firstcolumn,
							middlecolumn, false), lastcolumn, false));
		}
	}

	public Object invoke(IColumn column1, IColumn column2, boolean bool) {
		Object obj1, obj2;
		if (column1.value() != null) {
			obj1 = AppCase.read(column1.value(), deltadata);
		} else {
			obj1 = column1.getObjValue();
		}
		if (column2.value() != null) {
			obj2 = AppCase.read(column2.value(), deltadata);
		} else {
			obj2 = column2.getObjValue();
		}
		return AppCase.appendValue(obj1, obj2, bool, deltadata);
	}

	public Object invoke(Object obj, IColumn column2, boolean bool) {
		Object obj2;

		if (column2.value() != null) {
			obj2 = AppCase.read(column2.value(), deltadata);
		} else {
			obj2 = column2.getObjValue();
		}
		return AppCase.appendValue(obj, obj2, bool, deltadata);
	}

}
