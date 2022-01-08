package com.zhaokun.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LogAspects {

    @Pointcut("execution (public int com.zhaokun.aop.MathCalculator.*(..))")
    public void pointCat() {

    }

    @Before("pointCat()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("" + joinPoint.getSignature().getName() + "运行。。。@Before:参数列表是:{"+ Arrays.asList(args) +"}");
    }

    @After("pointCat()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println("" + joinPoint.getSignature().getName() +"结束。。。@After");
    }

    @AfterReturning(value = "pointCat()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println("" + joinPoint.getSignature().getName() + "返回正常。。。@AfterReturning:运行结果： {"+ result +"}");
    }

    @AfterThrowing(value = "pointCat()", throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception) {
        System.out.println(""+joinPoint.getSignature().getName()+"异常。。。异常信息：{"+exception+"}");
    }

}
