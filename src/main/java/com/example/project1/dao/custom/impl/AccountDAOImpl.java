package com.example.project1.dao.custom.impl;

import com.example.project1.dao.SQLUtil;
import com.example.project1.dao.custom.AccountDAO;
import com.example.project1.entity.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountDAOImpl implements AccountDAO {

    @Override
    public ArrayList<Account> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Account> allAccounts = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM accounts");
        while (rst.next()) {
            Account account = new Account(rst.getInt("AccountID"), rst.getDouble("Balance"));
            allAccounts.add(account);
        }
        return allAccounts;
    }

    @Override
    public boolean add(Account entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO accounts (AccountID, Balance) VALUES (?, ?)", entity.getAccountId(), entity.getBalance());
    }

    @Override
    public boolean update(Account entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE accounts SET Balance=? WHERE AccountID=?", entity.getBalance(), entity.getAccountId());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return exist(Integer.parseInt(id));
    }

    public boolean exist(int id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT AccountID FROM accounts WHERE AccountID=?", id);
        return rst.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Generate New ID is not supported for Account.");
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return delete(Integer.parseInt(id));
    }

    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM accounts WHERE AccountID=?", id);
    }

    @Override
    public Account search(String id) throws SQLException, ClassNotFoundException {
        return search(String.valueOf(Integer.parseInt(id)));

    }}