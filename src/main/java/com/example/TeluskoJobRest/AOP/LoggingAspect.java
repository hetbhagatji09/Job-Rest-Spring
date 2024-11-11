package com.example.TeluskoJobRest.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER=LoggerFactory.getLogger(LoggingAspect.class);

    //return type , class name , method name , args
    //com.example.TeluskoJobRest.Services.*.getJob this is point cut

    @Before("execution(* com.example.TeluskoJobRest.Services.*.getJob(..)) || execution(* com.example.TeluskoJobRest.Services.*.load(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("method called  {}", jp.getSignature().getName());

    }

    //run at last
    //it is like finaly it happens last

    @After("execution(* com.example.TeluskoJobRest.Services.*.getJob(..)) || execution(* com.example.TeluskoJobRest.Services.*.load(..))")
    public void logMethodCallAfter(JoinPoint jp){
        LOGGER.info("method Executed  {}", jp.getSignature().getName());

    }

    //call if and only if there will be exception

    @AfterThrowing("execution(* com.example.TeluskoJobRest.Services.*.getJob(..)) || execution(* com.example.TeluskoJobRest.Services.*.load(..))")
    public void logMethodCallAfterCrash(JoinPoint jp){
        LOGGER.info("{} method has some issue", jp.getSignature().getName());

    }
    //call if method compiled successfully
    @AfterReturning("execution(* com.example.TeluskoJobRest.Services.*.getJob(..)) || execution(* com.example.TeluskoJobRest.Services.*.load(..))")
    public void logMethodCallAfterSuccess(JoinPoint jp){
        LOGGER.info("method {} has run successfully", jp.getSignature().getName());

    }
}
