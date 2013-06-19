package org.apache.cassandra.db;

import java.io.IOError;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.cassandra.concurrent.Stage;
import org.apache.cassandra.concurrent.StageManager;
import org.apache.cassandra.config.Schema;
import org.apache.cassandra.config.ConfigurationException;
import org.apache.cassandra.db.migration.Migration;
import org.apache.cassandra.delta.DeltaFunction;
import org.apache.cassandra.delta.DeltaFunctionManager;
import org.apache.cassandra.delta.DeltaFunctionStore;
import org.apache.cassandra.net.IVerbHandler;
import org.apache.cassandra.net.Message;
import org.apache.cassandra.service.MigrationManager;
import org.apache.cassandra.utils.UUIDGen;
import org.apache.cassandra.utils.WrappedRunnable;

public class DeltaFunctionVerbHandler implements IVerbHandler
{
    private static final Logger logger = LoggerFactory.getLogger(DefinitionsUpdateVerbHandler.class);

    /** someone sent me their data definitions */
    public void doVerb(final Message message, String id)
    {
        try
        {
            // these are the serialized row mutations that I must apply.
            // check versions at every step along the way to make sure 'functions' are not applied out of order.
            Collection<Column> cols = DeltaFunctionManager.makeColumns(message);
            for (Column col : cols)
            {
                final UUID version = UUIDGen.getUUID(col.name());
                if (version.timestamp() > DeltaFunction.instance.getVersion().timestamp())
                {
                    final DeltaFunctionStore dfs = DeltaFunctionStore.deserialize(col.value(), version);
                    StageManager.getStage(Stage.DELTAFUNCTION).submit(new WrappedRunnable()
                    {
                        protected void runMayThrow() throws Exception
                        {
                            // check to make sure the current version is before this one.
                            if (DeltaFunction.instance.getVersion().timestamp() == version.timestamp())
                                logger.debug("Not appling (equal) " + version.toString());
                            else if (DeltaFunction.instance.getVersion().timestamp() > version.timestamp())
                                logger.debug("Not applying (before)" + version.toString());
                            else
                            {
                                logger.debug("Applying {} from {}", dfs.getClass().getSimpleName(), message.getFrom());
                                try
                                {
                                    dfs.writeDeltaFunction();
                                    // update gossip, but don't contact nodes directly
                                    dfs.passiveAnnounce();
                                }
                                catch (ConfigurationException ex)
                                {
                                    // Trying to apply the same migration twice. This happens as a result of gossip.
                                    logger.debug("DeltaFunction not applied " + ex.getMessage());
                                }
                            }
                        }
                    });
                }
            }
        }
        catch (IOException ex)
        {
            throw new IOError(ex);
        }
    }
}

