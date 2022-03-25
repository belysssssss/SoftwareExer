package com.example.softwareexer.mapper;

import com.example.softwareexer.entity.Grade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface GradeMapper {
    @Select("select * from grade")
    List<Grade> selectAll(int page,int size);

    @Select("select count(*) from grade order by pro asc")
    int getTotal();

    @Update("insert into grade(id,username,gradepass,gradeone,pro) values(#{id},#{username},#{gradepass},#{score},#{pro})")
    int change(Grade grade);
}
