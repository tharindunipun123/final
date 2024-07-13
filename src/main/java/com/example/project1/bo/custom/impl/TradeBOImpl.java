package com.example.project1.bo.custom.impl;

import com.example.project1.bo.custom.TradeBO;
import com.example.project1.dao.DAOFactory;
import com.example.project1.dao.custom.TradeDAO;
import com.example.project1.dto.TradeDTO;
import com.example.project1.entity.Trade;

public class TradeBOImpl implements TradeBO {

    TradeDAO tradeDAO = (TradeDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.TRADE);

    @Override
    public boolean placeTrade(TradeDTO tradeDTO) throws Exception {
        return tradeDAO.add(new Trade(tradeDTO.getInvestorID(), tradeDTO.getStockID(), java.sql.Date.valueOf(tradeDTO.getDate()), tradeDTO.getQuantity(), tradeDTO.getTradeType()));
    }
}
