package com.czq.aboutclass;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import javax.xml.ws.WebEndpoint;
import java.lang.reflect.Field;

/**
 * @author zhiqiang.cheng
 * @description
 * @date 2020/4/2
 */
@Aspect
public class NotNullPropertyAspect {


    @Pointcut("@annotaion(com.czq.aboutclass.NotNullProperty)")
    public void notNull(){}

    @Around("notNull()")
    public void around(JoinPoint joinPoint) throws Throwable{
        Object[] object = joinPoint.getArgs();
      //  System.out.println(object.length);
        Class c = object.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields){
            NotNullProperty no = f.getAnnotation(NotNullProperty.class);
            if (no != null && f.get(object) == null){
                throw new Exception(no.value()+"为空");
            }
        }
    }
}
