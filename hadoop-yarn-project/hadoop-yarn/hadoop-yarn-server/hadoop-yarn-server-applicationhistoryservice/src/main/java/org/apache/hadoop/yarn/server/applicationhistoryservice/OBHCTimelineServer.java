package org.apache.hadoop.yarn.server.applicationhistoryservice;

import org.apache.hadoop.yarn.server.OBHCServer.OBHCStatusServer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;

public class OBHCTimelineServer {

    public static Server createServer(int port) {
        Server server = new Server(port);
        ContextHandler context = new ContextHandler();
        context.setContextPath("/admin");

        context.setHandler(new OBHCStatusServer());
        server.setHandler(context);
        return server;
    }

    public static void main(String[] args) throws Exception {
        // Start OBHCStatus Server
        // https://www.eclipse.org/jetty/documentation/current/embedding-jetty.html#_embedding_contexts
        ApplicationHistoryServer ahs = new ApplicationHistoryServer();
        ahs.launchAppHistoryServer(args);

        int port = 1234;
        Server server = createServer(port);
        server.start();
        server.join();
    }
}