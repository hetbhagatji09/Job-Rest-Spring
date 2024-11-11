package com.example.TeluskoJobRest.AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER=LoggerFactory.getLogger(LoggingAspect.class);


    public void logMethodCall(){
        LOGGER.info("method called");

    }
}
