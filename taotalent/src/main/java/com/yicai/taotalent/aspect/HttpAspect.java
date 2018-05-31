package com.yicai.taotalent.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by RamboLi
 * Date 2018/4/20 0020
 * Time 16:34
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger=LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.yicai.taotalent.controller.GirlContorller.*(..))")
    public void log(){}
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
//        System.out.println("111111111111111111111");
//        logger.info("111111111111111111111");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //method
        logger.info("method={}",request.getMethod());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }
    @After("log()")
    public void doAfter(){
//        System.out.println("3333333333333333333333");
        logger.info("44444444444444444444444");
    }
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }
}
