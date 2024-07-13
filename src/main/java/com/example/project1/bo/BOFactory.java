package com.example.project1.bo;

import com.example.project1.bo.custom.impl.*;
import com.example.project1.bo.custom.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory() {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes {
        LOGIN, REGISTRATION, ACCOUNT, STOCK, TRADE
    }

    public SuperBO getBO(BOTypes types){
        switch (types){
            case LOGIN:
                return new LoginBOImpl();
            case REGISTRATION:
                return new RegistrationBOImpl();
            case ACCOUNT:
                return new AccountBOImpl();
            case STOCK:
                return new StockBOImpl();
            case TRADE:
//                return new TradeBOImpl();
            default:
                return null;
        }
    }
}
