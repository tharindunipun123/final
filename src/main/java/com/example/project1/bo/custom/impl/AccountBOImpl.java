package com.example.project1.bo.custom.impl;

import com.example.project1.bo.custom.AccountBO;
import com.example.project1.dao.DAOFactory;
import com.example.project1.dao.custom.AccountDAO;
import com.example.project1.dto.AccountDTO;
import com.example.project1.entity.Account;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class AccountBOImpl implements AccountBO {

    AccountDAO accountDAO = (AccountDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ACCOUNT);

    @Override
    public boolean addFunds(int accountId, double amount) throws Exception {
        Account account = accountDAO.search(String.valueOf(accountId));
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            return accountDAO.update(account);
        }
        return false;
    }

    @Override
    public boolean removeFunds(int accountId, double amount) throws Exception {
        Account account = accountDAO.search(String.valueOf(accountId));
        if (account != null) {
            account.setBalance(account.getBalance() - amount);
            return accountDAO.update(account);
        }
        return false;
    }

    @Override
    public ObservableList<AccountDTO> fetchAccounts() throws Exception {
        ArrayList<Account> allAccounts = accountDAO.getAll();
        ObservableList<AccountDTO> accountDTOs = FXCollections.observableArrayList();
        for (Account account : allAccounts) {
            accountDTOs.add(new AccountDTO(account.getAccountId(), account.getBalance()));
        }
        return accountDTOs;
    }
}
