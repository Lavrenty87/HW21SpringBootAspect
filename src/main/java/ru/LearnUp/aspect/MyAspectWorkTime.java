package ru.LearnUp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyAspectWorkTime {
    private long startMethod;
    private long endMethod;

    private static final Logger log = LoggerFactory.getLogger(MyAspectWorkTime.class);

    private JoinPoint joinPoint;
    //@Pointcut("execution(* ru.LearnUp.event.*.*(*))")
    @Pointcut(value = "@annotation(ru.LearnUp.annotation.WorkTime)")
    public void collIn() {
    }

    //WorkTime - все методы помеченные данной аннотацией должны выводить название метода и время работы метода
    @Before("collIn()")
    public void BeforeAnnotation(@NotNull JoinPoint joinPoint) {
        this.joinPoint = joinPoint;
        startMethod = System.currentTimeMillis();
    }

    @After("collIn()")
    public void AfterAnnotation(JoinPoint joinPoint){
        this.joinPoint = joinPoint;
        endMethod = System.currentTimeMillis();
        String nameMethod = joinPoint.getSignature().getName();
        log.info("Время работы: {} {}", nameMethod, endMethod - startMethod);
    }
}
