package com.example.project1.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;

    private DatabaseConnection() {
        // private constructor to prevent instantiation
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Configure these settings according to your database
                String url = "jdbc:mysql://localhost:3306/finalst";
                String user = "root";
                String password = "";
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println("Error connecting to the database: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return connection;
    }
}

