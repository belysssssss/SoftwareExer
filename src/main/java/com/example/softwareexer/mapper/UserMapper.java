package com.example.softwareexer.mapper;

import com.example.softwareexer.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where username= #{username}")
    User login(String username);

    @Insert("insert into user values(#{id},#{username},#{password})")
    int regist(User user);
}
