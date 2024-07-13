package com.example.project1.bo.custom;

import com.example.project1.bo.SuperBO;
import com.example.project1.dto.StockDTO;
import javafx.collections.ObservableList;

public interface StockBO extends SuperBO {
    ObservableList<StockDTO> loadStocks() throws Exception;
    void updateStockPrices() throws Exception;
    void showStockDetails(StockDTO stock) throws Exception;
}
