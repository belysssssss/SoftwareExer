package com.example.softwareexer.Return;

import lombok.Data;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Map;

@Data
public class CommentRes {
    private int code;
    private String msg;
    private Map data;

    private CommentRes(){
    }

    @SneakyThrows
    public CommentRes(int code, String msg, Map data){
        if (msg == null){
            // code参数非法
            throw new Exception("参数非法！");
        }
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
