package com.example.info.controller;

import com.example.info.model.Student;
import com.example.info.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by w景洋
 * on 2019/7/8
 */
@RestController
public class TestController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "get",method = RequestMethod.GET)
    public Student demoGetStudent(@RequestParam Integer stno){
        return studentService.select(stno);
    }

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public void demoAddStudent() throws InterruptedException {
        studentService.insert();
    }

    @RequestMapping(value = "notify",method = RequestMethod.GET)
    public void demoSync(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    studentService.insert();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                studentService.select(1);
            }
        }).start();
    }
}
