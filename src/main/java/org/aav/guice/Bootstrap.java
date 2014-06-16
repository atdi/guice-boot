package org.aav.guice;

import com.google.inject.servlet.GuiceFilter;
import lombok.extern.slf4j.Slf4j;
import org.aav.guice.web.GuiceContextListener;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

/**
 * Created by aurel.avramescu on 08/06/2014.
 */
@Slf4j
public class Bootstrap {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8000);
        ServletContextHandler handler =
                new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
        handler.addFilter(GuiceFilter.class, "/*", EnumSet.allOf(DispatcherType.class));
        GuiceContextListener contextListener = new GuiceContextListener();
        handler.addEventListener(contextListener);
        handler.addServlet(HttpServletDispatcher.class, "/*");
        server.start();
    }
}
