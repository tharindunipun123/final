package com.example.project1;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class StocksOverviewController {

    @FXML
    private TableView<Stock> stocksTable;
    @FXML
    private TableColumn<Stock, Integer> columnStockID;
    @FXML
    private TableColumn<Stock, String> columnName;
    @FXML
    private TableColumn<Stock, String> columnSymbol;
    @FXML
    private TableColumn<Stock, Double> columnCurrentPrice;
    @FXML
    private TextField searchField;

    private StocksModel model = new StocksModel();

    @FXML
    private void initialize() {
        columnStockID.setCellValueFactory(new PropertyValueFactory<>("stockID"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnSymbol.setCellValueFactory(new PropertyValueFactory<>("symbol"));
        columnCurrentPrice.setCellValueFactory(new PropertyValueFactory<>("currentPrice"));

        stocksTable.setItems(model.loadStocks());
    }

    @FXML
    private void handleRefresh() {
        stocksTable.setItems(model.loadStocks());
    }

    @FXML
    private void handleViewDetails() {
        Stock selectedStock = stocksTable.getSelectionModel().getSelectedItem();
        if (selectedStock != null) {
            model.showStockDetails(selectedStock);
        }
    }

    @FXML
    private void handleUpdatePrices() {
        model.updateStockPrices();
        handleRefresh();
    }
}
