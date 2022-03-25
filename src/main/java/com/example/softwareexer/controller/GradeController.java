package com.example.softwareexer.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.softwareexer.Return.CommentRes;
import com.example.softwareexer.entity.Grade;
import com.example.softwareexer.service.GradeService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("job")
public class GradeController {
    @Resource(name="grade")
    private GradeService gradeService;

    @RequestMapping("/queryAll")
    public String queryAll(int page,int size){
        return gradeService.query(page,size);
    }

    @PostMapping("/insert")
    public String insert(Grade grade){
        System.out.println(grade.toString());
        if (grade.getScore()==null){
            return JSONObject.toJSONString(new CommentRes(1, "成绩为空", null));
        }
        return gradeService.move(grade);
    }
}
