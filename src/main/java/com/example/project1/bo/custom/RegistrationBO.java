package com.example.project1.bo.custom;

import com.example.project1.bo.SuperBO;
import com.example.project1.dto.InvestorDTO;

public interface RegistrationBO extends SuperBO {
    boolean registerUser(InvestorDTO investorDTO) throws Exception;
}
