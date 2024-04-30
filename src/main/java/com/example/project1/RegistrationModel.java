package com.example.project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationModel {
    private Connection connection;

    public RegistrationModel() {
        connection = DatabaseConnection.getConnection();
    }

    public boolean registerUser(String name, String username, String password, String email, String contactInfo) {
        String sql = "INSERT INTO investor (Name, Username, HashedPassword, Email, ContactInfo) VALUES (?, ?, SHA2(?, 256), ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, username);
            stmt.setString(3, password);
            stmt.setString(4, email);
            stmt.setString(5, contactInfo);

            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            System.out.println("Error registering user: " + e.getMessage());
            return false;
        }
    }
}

