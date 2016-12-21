/*
 * Copyright (c) 2016 | James Kusmambang
 * Source : https://github.com/paralun
 */
package com.paralun.belajar.domain.listener;

import com.paralun.belajar.domain.UserList;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Application Initalized");
        UserList.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Good night world");
    }
}
