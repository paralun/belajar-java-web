/*
 * Copyright (c) 2016 | James Kusmambang
 * Source : https://github.com/paralun
 */
package com.paralun.belajar.domain.listener;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    private static Map<String, String> loginUser = new HashMap<>();

    @Override
    public void sessionCreated(HttpSessionEvent hse) {
        
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent sess) {
        removeLoginUser(sess.getSession().getId());
    }

    public static void addLoginUser(String username, HttpSession session) {
        loginUser.put(session.getId(), username);
    }

    public void removeLoginUser(String sessId) {
        loginUser.remove(sessId);
    }

    public static boolean isUserLogin(String name) {
        for (String sessId : loginUser.keySet()) {
            if (loginUser.get(sessId).equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
