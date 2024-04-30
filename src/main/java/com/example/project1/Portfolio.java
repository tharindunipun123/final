package com.example.project1;

public class Portfolio {
    private int portfolioId;
    private double totalValue;

    public Portfolio(int portfolioId, double totalValue) {
        this.portfolioId = portfolioId;
        this.totalValue = totalValue;
    }

    public int getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(int portfolioId) {
        this.portfolioId = portfolioId;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}
