package com.example.project1.bo.custom;

import com.example.project1.bo.SuperBO;
import com.example.project1.dto.AccountDTO;
import javafx.collections.ObservableList;

public interface AccountBO extends SuperBO {
    boolean addFunds(int accountId, double amount) throws Exception;
    boolean removeFunds(int accountId, double amount) throws Exception;
    ObservableList<AccountDTO> fetchAccounts() throws Exception;
}
