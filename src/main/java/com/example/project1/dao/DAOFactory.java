package com.example.project1.dao;

import com.example.project1.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDAOFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        INVESTOR, ACCOUNT, STOCK, TRADE
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case INVESTOR:
                return new InvestorDAOImpl();
            case ACCOUNT:
//                return new AccountDAOImpl();
//            case STOCK:
//                return new StockDAOImpl();
//            case TRADE:
//                return new TradeDAOImpl();
            default:
                return null;
        }
    }
}
