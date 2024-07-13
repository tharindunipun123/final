package com.example.project1.dto;

import java.time.LocalDate;

public class TradeDTO {
    private int investorID;
    private int stockID;
    private LocalDate date;
    private int quantity;
    private String tradeType;

    public TradeDTO(int investorID, int stockID, LocalDate date, int quantity, String tradeType) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
