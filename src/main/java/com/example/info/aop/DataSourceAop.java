package com.example.info.aop;

import com.example.info.service.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by w景洋
 * on 2019/7/8
 */
@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.example.info.annotation.Master) " +
            "&& (execution(* com.example.info.service..*.select*(..)) " +
            "|| execution(* com.example.info.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.example.info.annotation.Master) " +
            "|| execution(* com.example.info.service..*.insert*(..)) " +
            "|| execution(* com.example.info.service..*.add*(..)) " +
            "|| execution(* com.example.info.service..*.update*(..)) " +
            "|| execution(* com.example.info.service..*.edit*(..)) " +
            "|| execution(* com.example.info.service..*.delete*(..)) " +
            "|| execution(* com.example.info.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }


}
