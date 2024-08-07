package com.example.project1.controller;

import com.example.project1.bo.BOFactory;
import com.example.project1.bo.custom.TradeBO;
import com.example.project1.dto.TradeDTO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.time.LocalDate;

public class TradeScreenController {

    @FXML
    private TextField symbolField;
    @FXML
    private TextField quantityField;
    @FXML
    private TextField typeField; // To capture 'BUY' or 'SELL'

    private TradeBO tradeBO = (TradeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.TRADE);
    private int investorID = 1; // This should be dynamically set based on logged-in user

    @FXML
    private void handlePlaceTrade() {
        String symbol = symbolField.getText();
        String type = typeField.getText();
        int quantity;
        try {
            int stockID = getStockIDFromSymbol(symbol);
            quantity = Integer.parseInt(quantityField.getText());
            TradeDTO tradeDTO = new TradeDTO(investorID, stockID, LocalDate.now(), quantity, type);
            if (tradeBO.placeTrade(tradeDTO)) {
                showAlert("Trade Successful", "Trade successfully placed for " + quantity + " shares of " + symbol + ".");
                symbolField.clear();
                quantityField.clear();
                typeField.clear();
            } else {
                showAlert("Trade Failed", "Unable to place trade. Please check the details and try again.");
            }
        } catch (NumberFormatException e) {
            showAlert("Input Error", "Please enter a valid number for quantity.");
        } catch (Exception e) {
            showAlert("Error", "Error processing trade. " + e.getMessage());
        }
    }

    private int getStockIDFromSymbol(String symbol) throws Exception {
        // This method should query your database or a cache to find the stock ID based on the symbol
        // Placeholder for demonstration
        throw new Exception("Method not implemented. No stock ID found for symbol: " + symbol);
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
