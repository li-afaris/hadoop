package org.apache.hadoop.yarn.server.applicationhistoryservice;

import org.apache.hadoop.yarn.server.OBHCServer.OBHCStatusServer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;

public class OBHCTimelineServer {

    public static Server createOBHCServer(int port) {
        // Start OBHCStatus Server
        // https://www.eclipse.org/jetty/documentation/current/embedding-jetty.html#_embedding_contexts

        Server server = new Server(port);
        ContextHandler context = new ContextHandler();
        context.setContextPath("/admin");

        context.setHandler(new OBHCStatusServer());
        server.setHandler(context);
        return server;
    }

    public static void main(String[] args) throws Exception {

        ApplicationHistoryServer ahs = new ApplicationHistoryServer();
        new Thread((Runnable) ahs.launchAppHistoryServer(args)).start();

        int port = 1234;
        Server server = createOBHCServer(port);
        server.start();
        server.join();
    }
}