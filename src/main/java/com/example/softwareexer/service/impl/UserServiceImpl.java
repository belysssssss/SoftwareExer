package com.example.softwareexer.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.softwareexer.Return.CommentRes;
import com.example.softwareexer.entity.User;
import com.example.softwareexer.mapper.UserMapper;
import com.example.softwareexer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("login")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public String login( String username, String password) {
        User user = userMapper.login(username);
        // 登录结果校验
        if (user == null) {
            // 用户不存在
            return JSONObject.toJSONString(new CommentRes(1, "用户不存在", null));
        }
        if (!password.equals(user.getPassword())) {
            // 密码错误
            return JSONObject.toJSONString(new CommentRes(1, "用户名或密码错误", null));
        }
        // 登录成功
        Map<String, User> map = new HashMap<>();
        map.put("userInfo", user);
        return JSONObject.toJSONString(new CommentRes(0, "登录成功", map));
    }

    @Override
    public String regist(String username,String password) {
        String id = IdUtil.simpleUUID();
        User user = new User(id, username, password);
        int regist = 0;
        regist = userMapper.regist(user);
        if (regist != 1) {
            return JSONObject.toJSONString(new CommentRes(1, "注册失败", null));
        }
        Map<String, User> map = new HashMap<>();
        map.put("userInfo", user);
        // 注册成功，即可视为登录成功，返回结构是一样的
        return JSONObject.toJSONString(new CommentRes(0, "注册成功", map));
    }
}
