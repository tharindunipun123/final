package com.example.project1.model;

import com.example.project1.db.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StocksModel {

    private Connection connection;

    public StocksModel() {
        connection = DatabaseConnection.getConnection();
    }

    public ObservableList<Stock> loadStocks() {
        ObservableList<Stock> stocks = FXCollections.observableArrayList();
        String query = "SELECT StockID, Name, Symbol, CurrentPrice FROM stock";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                stocks.add(new Stock(rs.getInt("StockID"), rs.getString("Name"), rs.getString("Symbol"), rs.getDouble("CurrentPrice")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stocks;
    }

    public void updateStockPrices() {
        // Add logic to update stock prices based on your requirements
    }

    public void showStockDetails(Stock stock) {
        // Implement functionality to show detailed stock information
    }
}
