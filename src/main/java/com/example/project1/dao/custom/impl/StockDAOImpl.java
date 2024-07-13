package com.example.project1.dao.custom.impl;

import com.example.project1.dao.SQLUtil;
import com.example.project1.dao.custom.StockDAO;
import com.example.project1.entity.Stock;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StockDAOImpl implements StockDAO {

    @Override
    public ArrayList<Stock> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Stock> allStocks = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT StockID, Name, Symbol, CurrentPrice FROM stock");
        while (rst.next()) {
            Stock stock = new Stock(rst.getInt("StockID"), rst.getString("Name"), rst.getString("Symbol"), rst.getDouble("CurrentPrice"));
            allStocks.add(stock);
        }
        return allStocks;
    }

    @Override
    public boolean add(Stock entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO stock (StockID, Name, Symbol, CurrentPrice) VALUES (?, ?, ?, ?)", entity.getStockID(), entity.getName(), entity.getSymbol(), entity.getCurrentPrice());
    }

    @Override
    public boolean update(Stock entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE stock SET Name=?, Symbol=?, CurrentPrice=? WHERE StockID=?", entity.getName(), entity.getSymbol(), entity.getCurrentPrice(), entity.getStockID());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return exist(Integer.parseInt(id));
    }

    public boolean exist(int id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT StockID FROM stock WHERE StockID=?", id);
        return rst.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Generate New ID is not supported for Stock.");
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return delete(Integer.parseInt(id));
    }

    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM stock WHERE StockID=?", id);
    }

    @Override
    public Stock search(String id) throws SQLException, ClassNotFoundException {
        return search(Integer.parseInt(id));
    }

    public Stock search(int id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT StockID, Name, Symbol, CurrentPrice FROM stock WHERE StockID=?", id);
        if (rst.next()) {
            return new Stock(rst.getInt("StockID"), rst.getString("Name"), rst.getString("Symbol"), rst.getDouble("CurrentPrice"));
        }
        return null;
    }
}
