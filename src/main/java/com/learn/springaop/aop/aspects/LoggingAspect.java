package com.learn.springaop.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());
    // Pointcut - execution(* PACKAGE.*.*(..))
    //execution(* com.java/com/learn/springaop/aop/data.*.*(..))
    //If i want to intercept everything: execution(* com.java/com/learn/springaop/aop/*.*.*(..))
    @Before("execution(* com.learn.springaop.aop.business.*.*(..))")
    public void logMethodCall(JoinPoint joinPoint) {

        logger.info("Before Aspect - Method is called - {}", joinPoint);

    }
}
