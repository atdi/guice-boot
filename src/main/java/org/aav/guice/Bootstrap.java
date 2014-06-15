package org.aav.guice;

import com.google.inject.servlet.GuiceFilter;
import com.google.inject.servlet.GuiceServletContextListener;
import lombok.extern.slf4j.Slf4j;
import org.aav.guice.web.GuiceJerseyContextListener;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

/**
 * Created by aurel.avramescu on 08/06/2014.
 */
@Slf4j
public class Bootstrap {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8000);
        GuiceServletContextListener contextListener = new GuiceJerseyContextListener();
        ServletContextHandler handler = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
        handler.addFilter(GuiceFilter.class, "/*", EnumSet.allOf(DispatcherType.class));
        handler.addEventListener(contextListener);
        server.start();
    }
}
