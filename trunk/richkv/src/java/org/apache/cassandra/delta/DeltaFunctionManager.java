package org.apache.cassandra.delta;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.cassandra.concurrent.Stage;
import org.apache.cassandra.concurrent.StageManager;
import org.apache.cassandra.config.ConfigurationException;
import org.apache.cassandra.config.Schema;
import org.apache.cassandra.db.Column;
import org.apache.cassandra.db.IColumn;
import org.apache.cassandra.db.marshal.TimeUUIDType;
import org.apache.cassandra.db.migration.Migration;
import org.apache.cassandra.gms.ApplicationState;
import org.apache.cassandra.gms.EndpointState;
import org.apache.cassandra.gms.Gossiper;
import org.apache.cassandra.gms.IEndpointStateChangeSubscriber;
import org.apache.cassandra.gms.VersionedValue;
import org.apache.cassandra.io.util.FastByteArrayInputStream;
import org.apache.cassandra.io.util.FastByteArrayOutputStream;
import org.apache.cassandra.net.Message;
import org.apache.cassandra.net.MessagingService;
import org.apache.cassandra.service.MigrationManager;
import org.apache.cassandra.service.StorageService;
import org.apache.cassandra.utils.ByteBufferUtil;
import org.apache.cassandra.utils.FBUtilities;
import org.apache.cassandra.utils.UUIDGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Iterables;
import com.google.common.collect.MapMaker;

public class DeltaFunctionManager implements IEndpointStateChangeSubscriber
{
    private static final Logger logger = LoggerFactory.getLogger(MigrationManager.class);

    // avoids re-pushing migrations that we're waiting on target to apply already
    private static Map<InetAddress,UUID> lastPushed = new MapMaker().expiration(1, TimeUnit.MINUTES).makeMap();

    public void onJoin(InetAddress endpoint, EndpointState epState) { 
        VersionedValue value = epState.getApplicationState(ApplicationState.FUNCTION);
        if (value != null)
        {
            UUID theirVersion = UUID.fromString(value.value);
            rectify(theirVersion, endpoint);
        }
    }

    public void onChange(InetAddress endpoint, ApplicationState state, VersionedValue value)
    {
        if (state != ApplicationState.FUNCTION)
            return;
        UUID theirVersion = UUID.fromString(value.value);
        rectify(theirVersion, endpoint);
    }

    /** gets called after a this node joins a cluster */
    public void onAlive(InetAddress endpoint, EndpointState state)
    { 
        VersionedValue value = state.getApplicationState(ApplicationState.FUNCTION);
        if (value != null)
        {
            UUID theirVersion = UUID.fromString(value.value);
            rectify(theirVersion, endpoint);
        }
    }

    public void onDead(InetAddress endpoint, EndpointState state) { }

    public void onRestart(InetAddress endpoint, EndpointState state) { }

    public void onRemove(InetAddress endpoint) { }
    
    /** 
     * will either push or pull an updating depending on who is behind.
     * fat clients should never push their functions (since they have no local storage).
     */
    public static void rectify(UUID theirVersion, InetAddress endpoint)
    {
        UUID myVersion = Schema.instance.getVersion();
        if (theirVersion.timestamp() < myVersion.timestamp()
            && !StorageService.instance.isClientMode())
        {
            if (lastPushed.get(endpoint) == null || theirVersion.timestamp() >= lastPushed.get(endpoint).timestamp())
            {
                logger.debug("Schema on {} is old. Sending updates since {}", endpoint, theirVersion);
                Collection<IColumn> functions = DeltaFunctionStore.getLocalFunctions(theirVersion, myVersion);
                pushFunctions(endpoint, functions);
                lastPushed.put(endpoint, TimeUUIDType.instance.compose(Iterables.getLast(functions).name()));
            }
            else
            {
                logger.debug("Waiting for {} to process migrations up to {} before sending more",
                             endpoint, lastPushed.get(endpoint));
            }
        }
    }

    private static void pushFunctions(InetAddress endpoint, Collection<IColumn> functions)
    {
        try
        {
            Message msg = makeFunctionMessage(functions, Gossiper.instance.getVersion(endpoint));
            MessagingService.instance().sendOneWay(msg, endpoint);
        }
        catch (IOException ex)
        {
            throw new IOError(ex);
        }
    }

    /** actively announce a new version to active hosts via rpc */
    public static void announce(IColumn column)
    {

        Collection<IColumn> migrations = Collections.singleton(column);
        for (InetAddress endpoint : Gossiper.instance.getLiveMembers())
            pushFunctions(endpoint, migrations);
    }

    /** announce my version passively over gossip **/
    public static void passiveAnnounce(UUID version)
    {
        // this is for notifying nodes as they arrive in the cluster.
        Gossiper.instance.addLocalApplicationState(ApplicationState.FUNCTION, StorageService.instance.valueFactory.deltaFunction(version));
        logger.debug("Gossiping my delta function version " + version);
    }

    /**
     * gets called during startup if we notice a mismatch between the current migration version and the one saved. This
     * can only happen as a result of the commit log recovering schema updates, which overwrites lastVersionId.
     * 
     * This method silently eats IOExceptions thrown by Migration.apply() as a result of applying a migration out of
     * order.
     */
    public static void applyFunctions(final UUID from, final UUID to) throws IOException
    {
        List<Future<?>> updates = new ArrayList<Future<?>>();
        Collection<IColumn> functions = DeltaFunctionStore.getLocalFunctions(from, to);
        for (IColumn col : functions)
        {
            // assuming MessagingService.version_ is a bit of a risk, but you're playing with fire if you purposefully
            // take down a node to upgrade it during the middle of a schema update.
            final DeltaFunctionStore dfs = DeltaFunctionStore.deserialize(col.value(), UUIDGen.getUUID(col.name()));
            Future<?> update = StageManager.getStage(Stage.DELTAFUNCTION).submit(new Runnable()
            {
                public void run()
                {
                    try
                    {
                       dfs.writeDeltaFunction();
                    }
                    catch (ConfigurationException ex)
                    {
                        // this happens if we try to apply something that's already been applied. ignore and proceed.
                        logger.debug("Migration not applied " + ex.getMessage());
                    }
                    catch (IOException ex)
                    {
                        throw new RuntimeException(ex);
                    }
                }
            });
            updates.add(update);
        }
        
        // wait on all the updates before proceeding.
        for (Future<?> f : updates)
        {
            try
            {
                f.get();
            }
            catch (InterruptedException e)
            {
                throw new IOException(e);
            }
            catch (ExecutionException e)
            {
                throw new IOException(e);
            }
        }
        passiveAnnounce(to); // we don't need to send rpcs, but we need to update gossip
    }

    // other half of transformation is in DeltaFunctionVerbHandler.
    private static Message makeFunctionMessage(Collection<IColumn> functions, int version) throws IOException
    {
    	FastByteArrayOutputStream bout = new FastByteArrayOutputStream();
        DataOutputStream dout = new DataOutputStream(bout);
        dout.writeInt(functions.size());
        
        for (IColumn col : functions)
        {
            assert col instanceof Column;
            ByteBufferUtil.writeWithLength(col.name(), dout);
            ByteBufferUtil.writeWithLength(col.value(), dout);
        }
        dout.close();
        byte[] body = bout.toByteArray();
        return new Message(FBUtilities.getBroadcastAddress(), StorageService.Verb.DELTA_FUNCTION, body, version);
    }
    
    // other half of this transformation is in DeltaFunctionManager.
    public static Collection<Column> makeColumns(Message msg) throws IOException
    {
        Collection<Column> cols = new ArrayList<Column>();
        DataInputStream in = new DataInputStream(new FastByteArrayInputStream(msg.getMessageBody()));
        int count = in.readInt();
        for (int i = 0; i < count; i++)
        {
            byte[] name = new byte[in.readInt()];
            in.readFully(name);
            byte[] value = new byte[in.readInt()];
            in.readFully(value);
            cols.add(new Column(ByteBuffer.wrap(name), ByteBuffer.wrap(value)));
        }
        in.close();
        return cols;
    }
}
