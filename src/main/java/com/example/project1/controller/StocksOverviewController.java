package com.example.project1.controller;

import com.example.project1.bo.BOFactory;
import com.example.project1.bo.custom.StockBO;
import com.example.project1.dto.StockDTO;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class StocksOverviewController {

    @FXML
    private TableView<StockDTO> stocksTable;
    @FXML
    private TableColumn<StockDTO, Integer> columnStockID;
    @FXML
    private TableColumn<StockDTO, String> columnName;
    @FXML
    private TableColumn<StockDTO, String> columnSymbol;
    @FXML
    private TableColumn<StockDTO, Double> columnCurrentPrice;
    @FXML
    private TextField searchField;

    private StockBO stockBO = (StockBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STOCK);

    @FXML
    private void initialize() {
        columnStockID.setCellValueFactory(new PropertyValueFactory<>("stockID"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnSymbol.setCellValueFactory(new PropertyValueFactory<>("symbol"));
        columnCurrentPrice.setCellValueFactory(new PropertyValueFactory<>("currentPrice"));

        try {
            stocksTable.setItems(stockBO.loadStocks());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleRefresh() {
        try {
            stocksTable.setItems(stockBO.loadStocks());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleViewDetails() {
        StockDTO selectedStock = stocksTable.getSelectionModel().getSelectedItem();
        if (selectedStock != null) {
            try {
                stockBO.showStockDetails(selectedStock);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void handleUpdatePrices() {
        try {
            stockBO.updateStockPrices();
            handleRefresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
