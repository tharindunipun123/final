package com.example.project1.entity;

import java.sql.Date;

public class Trade {
    private int investorID;
    private int stockID;
    private Date date;
    private int quantity;
    private String tradeType;

    public Trade(int investorID, int stockID, Date date, int quantity, String tradeType) {
        this.investorID = investorID;
        this.stockID = stockID;
        this.date = date;
        this.quantity = quantity;
        this.tradeType = tradeType;
    }

    public int getInvestorID() {
        return investorID;
    }

    public void setInvestorID(int investorID) {
        this.investorID = investorID;
    }

    public int getStockID() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }
}
