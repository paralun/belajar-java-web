/*
 * Copyright (c) 2016 | James Kusmambang
 * Source : https://github.com/paralun
 */
package com.paralun.app;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("SESSION BARU TELAH DIBUAT");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("SESSION TELAH DI HAPUS");
    }
}
