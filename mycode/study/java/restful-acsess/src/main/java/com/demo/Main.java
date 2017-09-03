package com.demo;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import com.sun.jersey.spi.container.servlet.ServletContainer;
public class Main {
    public static void main(String[] args) throws Exception {
        Server server=new Server(82);
        ServletHolder servlet = new ServletHolder(ServletContainer.class);
        servlet.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", "com.sun.jersey.api.core.PackagesResourceConfig");
        servlet.setInitParameter("com.sun.jersey.config.property.packages", "com.demo.action");
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/");
        handler.addServlet(servlet, "/*");
        server.setHandler(handler);
        server.start();
        System.out.println("start...in 82");
    }

}