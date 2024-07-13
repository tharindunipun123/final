package com.example.project1.bo.custom.impl;

import com.example.project1.bo.custom.StockBO;
import com.example.project1.dao.DAOFactory;
import com.example.project1.dao.custom.StockDAO;
import com.example.project1.dto.StockDTO;
import com.example.project1.entity.Stock;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class StockBOImpl implements StockBO {

    StockDAO stockDAO = (StockDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STOCK);

    @Override
    public ObservableList<StockDTO> loadStocks() throws Exception {
        ArrayList<Stock> allStocks = stockDAO.getAll();
        ObservableList<StockDTO> stockDTOs = FXCollections.observableArrayList();
        for (Stock stock : allStocks) {
            stockDTOs.add(new StockDTO(stock.getStockID(), stock.getName(), stock.getSymbol(), stock.getCurrentPrice()));
        }
        return stockDTOs;
    }

    @Override
    public void updateStockPrices() throws Exception {
        // Add logic to update stock prices based on your requirements
    }

    @Override
    public void showStockDetails(StockDTO stock) throws Exception {
        // Implement functionality to show detailed stock information
    }
}
