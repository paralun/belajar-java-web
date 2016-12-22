/*
 * Copyright (c) 2016 | James Kusmambang
 * Source : https://github.com/paralun
 */
package com.paralun.app;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("SERVLET CONTEXT DIBUAT");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
    
}
