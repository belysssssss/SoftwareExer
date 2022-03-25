package com.example.softwareexer.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.extra.mail.MailUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.softwareexer.Return.CommentRes;
import com.example.softwareexer.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {
    @Resource(name="login")
    private UserService userService;
    @RequestMapping("/login")
    public String login(@RequestParam String username,@RequestParam String password){
        // 非空校验
        if (StringUtils.isAnyBlank(username, password)) {
            return JSONObject.toJSONString(new CommentRes(1, "参数为空！", null));
        }
        return userService.login( username, password);
    }

    @RequestMapping("/regist")
    public String regist(@RequestParam String username,
                         @RequestParam String password) {
        // 校验
        if (StringUtils.isAnyBlank(username, password)) {
            return JSONObject.toJSONString(new CommentRes(1, "参数为空！", null));
        }
        System.out.println(username+" "+password);
        JSONObject registInfo = new JSONObject();
        registInfo.put("username",username);
        registInfo.put("password", password);
        return userService.regist(username,password);
    }
}
