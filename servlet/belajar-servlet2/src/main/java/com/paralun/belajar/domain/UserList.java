/*
 * Copyright (c) 2016 | James Kusmambang
 * Source : https://github.com/paralun
 */
package com.paralun.belajar.domain;

import java.util.HashMap;
import java.util.Map;

public class UserList {

    private final Map<String, String> userListDetail; // username , password
    private static UserList instance;

    public static void init() {
        instance = new UserList();
    }

    public static UserList getInstance() {
        return instance;
    }

    public boolean validUser(String name, String password) {
        if (userListDetail.containsKey(name)) {
            return userListDetail.get(name).equalsIgnoreCase(password);
        } else {
            return false;
        }
    }

    public UserList() {
        userListDetail = new HashMap<>();

        userListDetail.put("agung", "agung");
        userListDetail.put("bayu", "bayu");
        userListDetail.put("iswara", "iswara");

        for (String key : userListDetail.keySet()) {
            System.out.println("User " + key + " loaded to memory");
        }
    }
}
