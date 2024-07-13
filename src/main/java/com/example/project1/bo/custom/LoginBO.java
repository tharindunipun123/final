package com.example.project1.bo.custom;

import com.example.project1.bo.SuperBO;

public interface LoginBO extends SuperBO {
    boolean isLogin(String user, String pass) throws Exception;
}
