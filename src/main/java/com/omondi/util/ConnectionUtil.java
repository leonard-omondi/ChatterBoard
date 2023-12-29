package com.omondi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/chatterboard_db";
    // Use your own MySQL Workbench username and password below
    private static final String USERNAME = "xxxx";
    private static final String PASSWORD = "xxxx";

    public static Connection getConnection() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Database connected successfully? " + connection.isValid(10));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

}
