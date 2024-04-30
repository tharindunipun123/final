package com.example.project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;

public class AccountsModel {

    private Connection connection;

    public AccountsModel() {
        connection = DatabaseConnection.getConnection();
    }

    public void addFunds(int accountId, double amount) {
        String sql = "UPDATE accounts SET Balance = Balance + ? WHERE AccountID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, amount);
            stmt.setInt(2, accountId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeFunds(int accountId, double amount) {
        String sql = "UPDATE accounts SET Balance = Balance - ? WHERE AccountID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, amount);
            stmt.setInt(2, accountId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStockToPortfolio(int portfolioId, String symbol, int quantity) {
        String sql = "INSERT INTO portfolio_stocks (PortfolioID, Symbol, Quantity) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE Quantity = Quantity + ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, portfolioId);
            stmt.setString(2, symbol);
            stmt.setInt(3, quantity);
            stmt.setInt(4, quantity);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeStockFromPortfolio(int portfolioId, String symbol, int quantity) {
        String sql = "UPDATE portfolio_stocks SET Quantity = Quantity - ? WHERE PortfolioID = ? AND Symbol = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, quantity);
            stmt.setInt(2, portfolioId);
            stmt.setString(3, symbol);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                cleanUpPortfolioEntries(portfolioId, symbol);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cleanUpPortfolioEntries(int portfolioId, String symbol) {
        String sql = "DELETE FROM portfolio_stocks WHERE PortfolioID = ? AND Symbol = ? AND Quantity <= 0";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, portfolioId);
            stmt.setString(2, symbol);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Account> fetchAccounts() {
        ObservableList<Account> accounts = FXCollections.observableArrayList();
        String sql = "SELECT AccountID, Balance FROM accounts";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                accounts.add(new Account(rs.getInt("AccountID"), rs.getDouble("Balance")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public ObservableList<Portfolio> fetchPortfolios() {
        ObservableList<Portfolio> portfolios = FXCollections.observableArrayList();
        String sql = "SELECT PortfolioID, TotalValue FROM portfolios";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                portfolios.add(new Portfolio(rs.getInt("PortfolioID"), rs.getDouble("TotalValue")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return portfolios;
    }
}

