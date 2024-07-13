package com.example.project1.dao.custom.impl;

import com.example.project1.dao.SQLUtil;
import com.example.project1.dao.SuperDAO;
import com.example.project1.dao.custom.InvestorDAO;
import com.example.project1.entity.Investor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InvestorDAOImpl implements InvestorDAO, SuperDAO {

    @Override
    public ArrayList<Investor> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Investor> allInvestors = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM investor");
        while (rst.next()) {
            Investor investor = new Investor(rst.getString("name"), rst.getString("username"), rst.getString("hashedPassword"), rst.getString("email"), rst.getString("contactInfo"));
            allInvestors.add(investor);
        }
        return allInvestors;
    }

    @Override
    public boolean add(Investor entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO investor (Name, Username, HashedPassword, Email, ContactInfo) VALUES (?, ?, SHA2(?, 256), ?, ?)",
                entity.getName(), entity.getUsername(), entity.getHashedPassword(), entity.getEmail(), entity.getContactInfo());
    }

    @Override
    public boolean update(Investor entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE investor SET Name=?, HashedPassword=SHA2(?, 256), Email=?, ContactInfo=? WHERE Username=?",
                entity.getName(), entity.getHashedPassword(), entity.getEmail(), entity.getContactInfo(), entity.getUsername());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT username FROM investor WHERE username=?", id);
        return rst.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Generate New ID is not supported for Investor.");
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM investor WHERE username=?", id);
    }

    @Override
    public Investor search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM investor WHERE username=?", id);
        if (rst.next()) {
            return new Investor(rst.getString("name"), rst.getString("username"), rst.getString("hashedPassword"), rst.getString("email"), rst.getString("contactInfo"));
        }
        return null;
    }
}
