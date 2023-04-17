package com.example.modelemvc.service;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    public static Connection INSTANCE;

    public static Connection openConnection() {
        String url = "jdbc:mysql://localhost:3306/db-posts";
        String user = "root";
        String pwd = "emRS1M989G%q";
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            if (INSTANCE == null) {
                INSTANCE = DriverManager.getConnection(url, user, pwd);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return INSTANCE;
    }

    public static void closeConnection() {
        try {
            if (INSTANCE != null && !INSTANCE.isClosed()) {
                INSTANCE.close();
                DriverManager.deregisterDriver(new com.mysql.cj.jdbc.Driver());
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

}
