/*
 * Copyright (c) 2016 | James Kusmambang
 * Source : https://github.com/paralun
 */
package com.paralun.app.util;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.paralun.app.dao.ClubDao;
import com.paralun.app.dao.ClubDaoImpl;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseUtil {
    
    private static Connection connection;
    private static ClubDao clubDao;

    public static Connection getConnection() {
        if(connection == null) {
            try {
                MysqlDataSource source = new MysqlDataSource();
                source.setUrl("jdbc:mysql://localhost:3306/servletDB");
                source.setUser("root");
                source.setPassword("mysql135");
                
                connection = source.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }

    public static ClubDao getClubDao() {
        if(clubDao == null) {
            clubDao = new ClubDaoImpl(getConnection());
        }
        return clubDao;
    }
}
