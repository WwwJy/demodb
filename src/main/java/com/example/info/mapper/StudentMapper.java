package com.example.info.mapper;

import com.example.info.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer stno);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer stno);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}