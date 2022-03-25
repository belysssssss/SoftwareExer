package com.example.softwareexer.service;


import com.alibaba.fastjson.JSONObject;

public interface UserService {

    default String login(String username, String password) {
        return null;
    }

    default String regist(String username,String password) {
        return null;
    }
}
