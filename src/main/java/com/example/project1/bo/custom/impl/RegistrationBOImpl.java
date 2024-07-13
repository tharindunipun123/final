package com.example.project1.bo.custom.impl;

import com.example.project1.bo.custom.RegistrationBO;
import com.example.project1.dao.DAOFactory;
import com.example.project1.dao.custom.InvestorDAO;
import com.example.project1.dto.InvestorDTO;
import com.example.project1.entity.Investor;

public class RegistrationBOImpl implements RegistrationBO {

    InvestorDAO investorDAO = (InvestorDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.INVESTOR);

    @Override
    public boolean registerUser(InvestorDTO investorDTO) throws Exception {
        Investor investor = new Investor(investorDTO.getName(), investorDTO.getUsername(), investorDTO.getHashedPassword(), investorDTO.getEmail(), investorDTO.getContactInfo());
        return investorDAO.add(investor);
    }
}
