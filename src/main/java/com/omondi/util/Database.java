package com.omondi.util;

import java.sql.*;

public class Database {

    private static final String DATABASE_NAME = "chatterboard_db";
    private static final String TABLE_NAME = "messages";

    public static void setup() {

        try (Connection connection = ConnectionUtil.getConnection();
                Statement statement = connection.createStatement()) {

            // Create the database if not exists
            int result = statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DATABASE_NAME);
            System.out.println("Create Database Result: " + result);

            // Use the created database
            statement.executeUpdate("USE " + DATABASE_NAME);

            // Create the 'account' table if not exists
            String createNotesTableQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "comment VARCHAR(255) NOT NULL,"
                    + "priority VARCHAR(255) NOT NULL"
                    + ")";
            result = statement.executeUpdate(createNotesTableQuery);
            System.out.println("Create Table Result: " + result);

        } catch (SQLException e) {
            System.out.println("Error creating database or tables: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
