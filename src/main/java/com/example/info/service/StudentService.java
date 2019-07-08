package com.example.info.service;

import com.example.info.mapper.StudentMapper;
import com.example.info.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by w景洋
 * on 2019/7/8
 */
@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    public Student select(Integer stno){
        Student student = studentMapper.selectByPrimaryKey(stno);
        System.out.println("查询成功");
        return student;
    }

    public void insert() throws InterruptedException {
        Thread.sleep(5000);
        Student student = new Student();
        student.setStno(5);
        student.setStname("wjy");
        int i = studentMapper.insert(student);
        if (i>0){
            System.out.println("添加成功");
        }

    }
}
