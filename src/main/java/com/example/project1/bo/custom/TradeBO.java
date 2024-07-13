package com.example.project1.bo.custom;

import com.example.project1.dto.TradeDTO;

public interface TradeBO {
    boolean placeTrade(TradeDTO tradeDTO) throws Exception;
}
