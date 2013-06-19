package org.apache.cassandra.db;

import org.apache.cassandra.delta.DeltaFunction;
import org.apache.cassandra.net.IVerbHandler;
import org.apache.cassandra.net.Message;
import org.apache.cassandra.net.MessagingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FunctionCheckVerbHandler implements IVerbHandler
{
    private final Logger logger = LoggerFactory.getLogger(FunctionCheckVerbHandler.class);
    
    public void doVerb(Message message, String id)
    {
        logger.debug("Received function check request.");
        Message response = message.getInternalReply(DeltaFunction.instance.getVersion().toString().getBytes(), message.getVersion());
        MessagingService.instance().sendReply(response, id, message.getFrom());
    }
}
