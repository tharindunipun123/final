package com.example.project1;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AccountsManagementController {

    @FXML
    private TableView<Account> accountsTable;
    @FXML
    private TableView<Portfolio> portfoliosTable;
    @FXML
    private TextField amountField;
    @FXML
    private TextField stockField;
    @FXML
    private TextField quantityField;

    private AccountsModel model = new AccountsModel();

    @FXML
    private void handleAddFunds() {
        double amount = Double.parseDouble(amountField.getText());
        Account selected = accountsTable.getSelectionModel().getSelectedItem();
        model.addFunds(selected.getAccountId(), amount);
        refreshAccounts();
    }

    @FXML
    private void handleRemoveFunds() {
        double amount = Double.parseDouble(amountField.getText());
        Account selected = accountsTable.getSelectionModel().getSelectedItem();
        model.removeFunds(selected.getAccountId(), amount);
        refreshAccounts();
    }

    @FXML
    private void handleAddStock() {
        String symbol = stockField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        Portfolio selected = portfoliosTable.getSelectionModel().getSelectedItem();
        model.addStockToPortfolio(selected.getPortfolioId(), symbol, quantity);
        refreshPortfolios();
    }

    @FXML
    private void handleRemoveStock() {
        String symbol = stockField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        Portfolio selected = portfoliosTable.getSelectionModel().getSelectedItem();
        model.removeStockFromPortfolio(selected.getPortfolioId(), symbol, quantity);
        refreshPortfolios();
    }

    private void refreshAccounts() {
        accountsTable.setItems(model.fetchAccounts());
    }

    private void refreshPortfolios() {
        portfoliosTable.setItems(model.fetchPortfolios());
    }
}
