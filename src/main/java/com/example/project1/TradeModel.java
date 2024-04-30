package com.example.project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class TradeModel {

    private Connection connection;

    public TradeModel() {
        this.connection = DatabaseConnection.getConnection();
    }

    public boolean placeTrade(int investorID, int stockID, String type, int quantity) {
        String insertTradeSQL = "INSERT INTO trade (InvestorID, StockID, Date, Quantity, TradeType) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(insertTradeSQL)) {
            stmt.setInt(1, investorID);
            stmt.setInt(2, stockID);
            stmt.setDate(3, java.sql.Date.valueOf(LocalDate.now()));  // Current date
            stmt.setInt(4, quantity);
            stmt.setString(5, type);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
