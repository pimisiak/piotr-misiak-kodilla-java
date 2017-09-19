package com.kodilla.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

class DbManager {
    private final Connection conn;
    private static DbManager dbManagerInstance;

    private DbManager() throws SQLException {
        final Properties connectionProps = new Properties();
        connectionProps.put("user", "kodilla_user");
        connectionProps.put("password", "kodilla_password");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kodilla_course?serverTimezone=Europe/Warsaw&useSSL=False", connectionProps);
    }

    static DbManager getInstance() throws SQLException {
        if (dbManagerInstance == null) {
            dbManagerInstance = new DbManager();
        }
        return dbManagerInstance;
    }

    Connection getConnection() {
        return conn;
    }
}
