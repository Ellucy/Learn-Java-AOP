package com.learn.springaop.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfiq {

    @Pointcut("execution(* com.learn.springaop.aop.*.*.*(..))")
    public void businessAndDataPackageConfiq() {}

    @Pointcut("execution(* com.learn.springaop.aop.business.*.*(..))")
    public void businessPackageConfiq() {}

    @Pointcut("execution(* com.learn.springaop.aop.data.*.*(..))")
    public void dataPackageConfiq() {}

    @Pointcut("bean(*Service*)")
    public void dataPackageConfiqUsingBean() {}

    @Pointcut("@annotation(com.learn.springaop.aop.annotations.TrackTime)")
    public void trackTimeAnnotation() {}
}
