package com.example.project1.entity;

public class Stock {
    private int stockID;
    private String name;
    private String symbol;
    private double currentPrice;

    public Stock(int stockID, String name, String symbol, double currentPrice) {
        this.stockID = stockID;
        this.name = name;
        this.symbol = symbol;
        this.currentPrice = currentPrice;
    }

    public int getStockID() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
}
