package com.example.softwareexer.service;

import com.example.softwareexer.entity.Grade;


public interface GradeService {
    default String query(int page,int size){
        return null;
    }
    default String move(Grade grade){
        return null;
    }
}
