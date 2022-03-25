package com.example.softwareexer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String  id;
    private String username;//用户名--用于登录
    private String password;//密码
}
