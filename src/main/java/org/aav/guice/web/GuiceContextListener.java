package org.aav.guice.web;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.GuiceServletContextListener;
import lombok.extern.slf4j.Slf4j;
import org.aav.guice.modules.ResourcesModule;
import org.aav.guice.modules.PersistenceModule;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by aurel.avramescu on 09/06/2014.
 */
@Slf4j
public class GuiceContextListener extends GuiceResteasyBootstrapServletContextListener {

    /**
     * Override this method to instantiate your {@link com.google.inject.Module}s yourself.
     *
     * @param context
     * @return
     */
    protected List<? extends Module> getModules(final ServletContext context)
    {
        final List<Module> result = new ArrayList<Module>();
        result.add(new PersistenceModule());
        result.add(new ResourcesModule());
        return result;
    }
}

