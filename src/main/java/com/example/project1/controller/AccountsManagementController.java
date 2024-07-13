package com.example.project1.controller;

import com.example.project1.bo.BOFactory;
import com.example.project1.bo.custom.AccountBO;
import com.example.project1.dto.AccountDTO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AccountsManagementController {

    @FXML
    private TableView<AccountDTO> accountsTable;
    @FXML
    private TextField amountField;

    private AccountBO accountBO = (AccountBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ACCOUNT);

    @FXML
    private void handleAddFunds() {
        double amount = Double.parseDouble(amountField.getText());
        AccountDTO selected = accountsTable.getSelectionModel().getSelectedItem();
        try {
            accountBO.addFunds(selected.getAccountId(), amount);
            refreshAccounts();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleRemoveFunds() {
        double amount = Double.parseDouble(amountField.getText());
        AccountDTO selected = accountsTable.getSelectionModel().getSelectedItem();
        try {
            accountBO.removeFunds(selected.getAccountId(), amount);
            refreshAccounts();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void refreshAccounts() {
        try {
            ObservableList<AccountDTO> accounts = accountBO.fetchAccounts();
            accountsTable.setItems(accounts);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
