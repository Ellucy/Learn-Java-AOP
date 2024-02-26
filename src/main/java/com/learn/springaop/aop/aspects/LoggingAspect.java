package com.learn.springaop.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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
    @Before("com.learn.springaop.aop.aspects.CommonPointcutConfiq.businessPackageConfiq()")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {

        logger.info("Before Aspect - {} is called - with arguments: {}",
                joinPoint, joinPoint.getArgs());
    }

    @After("com.learn.springaop.aop.aspects.CommonPointcutConfiq.dataPackageConfiqUsingBean()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {

        logger.info("+++After Aspect - {} has executed", joinPoint);
    }

    @AfterThrowing(
            pointcut = "com.learn.springaop.aop.aspects.CommonPointcutConfiq.businessAndDataPackageConfiq()",
            throwing = "exception"
    )
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {

        logger.info("AfterThrowing Aspect - {} has thrown an exception {}"
                , joinPoint, exception);
    }

    @AfterReturning(
            pointcut = "com.learn.springaop.aop.aspects.CommonPointcutConfiq.dataPackageConfiq()",
            returning = "resultValue"
    )
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {

        logger.info("AfterReturning Aspect - {} has returned a resultalue {}"
                , joinPoint, resultValue);
    }

}
