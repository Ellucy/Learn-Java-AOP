package com.learn.springaop.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

//    @Around("com.learn.springaop.aop.aspects.CommonPointcutConfiq.businessAndDataPackageConfiq()")
    @Around("com.learn.springaop.aop.aspects.CommonPointcutConfiq.trackTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        Object returnValue = proceedingJoinPoint.proceed();

        long stopTime = System.currentTimeMillis();
        long executionDuration = stopTime - startTime;

        logger.info("Around Aspect - {} Method executed in {}", proceedingJoinPoint, executionDuration);

        return returnValue;
    }
}
