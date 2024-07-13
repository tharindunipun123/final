package com.example.project1.bo.custom.impl;

import com.example.project1.bo.custom.LoginBO;
import com.example.project1.dao.DAOFactory;
import com.example.project1.dao.custom.InvestorDAO;
import com.example.project1.entity.Investor;

public class LoginBOImpl implements LoginBO {

    InvestorDAO investorDAO = (InvestorDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.INVESTOR);

    @Override
    public boolean isLogin(String user, String pass) throws Exception {
        Investor investor = investorDAO.search(user);
        if (investor != null && investor.getHashedPassword().equals(pass)) {
            return true;
        }
        return false;
    }
}
