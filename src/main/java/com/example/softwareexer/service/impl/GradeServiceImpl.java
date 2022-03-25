package com.example.softwareexer.service.impl;
import com.alibaba.fastjson.JSONObject;
import com.example.softwareexer.Return.CommentRes;
import com.example.softwareexer.entity.Grade;
import com.example.softwareexer.mapper.GradeMapper;
import com.example.softwareexer.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("grade")
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeMapper gradeMapper;
    @Override
    public String query(int page,int size){
        List<Grade> list = gradeMapper.selectAll(page,size);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        int total = gradeMapper.getTotal();
        if (list==null || total==0){
            return JSONObject.toJSONString(new CommentRes(0,"暂无成绩",null));
        }
        Map<String,Object> map = new HashMap();
        map.put("list",list);
        map.put("total",total);
        return JSONObject.toJSONString(new CommentRes(0,"查询成功",map));
    }
    @Override
    public String move(Grade grade){
        int update = gradeMapper.change(grade);
        if (update != 1) {
            return JSONObject.toJSONString(new CommentRes(1,"提交失败",null));
        }
        Map<String, Object> map = new HashMap<>();
        map.put("gradeInfo", grade);
        return JSONObject.toJSONString(new CommentRes(0,"提交成功",map));
    }
}
