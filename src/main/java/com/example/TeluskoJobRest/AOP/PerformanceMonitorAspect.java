package com.example.TeluskoJobRest.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {

    private static final Logger LOGGER= LoggerFactory.getLogger(PerformanceMonitorAspect.class);


    @Around("execution(* com.example.TeluskoJobRest.Services.*.getJob(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {

        long startTime=System.currentTimeMillis();
        Object obj=jp.proceed();

        long endTime=System.currentTimeMillis();

        LOGGER.info("Time Taken "+ jp.getSignature().getName()+" "+(endTime-startTime));
        return obj;

    }
}
