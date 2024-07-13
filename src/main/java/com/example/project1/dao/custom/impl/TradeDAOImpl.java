package com.example.project1.dao.custom.impl;

import com.example.project1.dao.SQLUtil;
import com.example.project1.dao.custom.TradeDAO;
import com.example.project1.entity.Trade;

import java.sql.SQLException;
import java.util.ArrayList;

public class TradeDAOImpl implements TradeDAO {

    @Override
    public ArrayList<Trade> getAll() throws SQLException, ClassNotFoundException {
        // Implement if needed
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public boolean add(Trade trade) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO trade (InvestorID, StockID, Date, Quantity, TradeType) VALUES (?, ?, ?, ?, ?)",
                trade.getInvestorID(), trade.getStockID(), trade.getDate(), trade.getQuantity(), trade.getTradeType());
    }

    @Override
    public boolean update(Trade trade) throws SQLException, ClassNotFoundException {
        // Implement if needed
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        // Implement if needed
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        // Implement if needed
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        // Implement if needed
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Trade search(String id) throws SQLException, ClassNotFoundException {
        // Implement if needed
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
