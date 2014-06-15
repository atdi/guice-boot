package org.aav.guice.web;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import lombok.extern.slf4j.Slf4j;
import org.aav.guice.modules.JerseyModule;
import org.aav.guice.modules.PersistenceModule;


/**
 * Created by aurel.avramescu on 09/06/2014.
 */
@Slf4j
public class GuiceJerseyContextListener extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new JerseyModule(), new PersistenceModule());
    }

}

