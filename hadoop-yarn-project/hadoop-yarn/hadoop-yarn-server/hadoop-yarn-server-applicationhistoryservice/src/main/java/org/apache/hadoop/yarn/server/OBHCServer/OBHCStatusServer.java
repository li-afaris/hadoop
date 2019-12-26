package org.apache.hadoop.yarn.server.OBHCServer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;


public class OBHCStatusServer extends AbstractHandler {
    private final String status;
    // Copied from ...
    // https://www.eclipse.org/jetty/documentation/current/embedding-jetty.html#_using_handlers

    public OBHCStatusServer() {
        this("GOOD");
    }

    public OBHCStatusServer(String status) {
        this.status = status;
    }

    @Override
    public void handle(String target,
                       Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = response.getWriter();
        out.println("GOOD");
        baseRequest.setHandled(true);
    }
}
