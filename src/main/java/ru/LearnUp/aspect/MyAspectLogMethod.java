package ru.LearnUp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class MyAspectLogMethod {

    private static final Logger log = LoggerFactory.getLogger(MyAspectLogMethod.class);
    private JoinPoint joinPoint;

    @Pointcut("execution(* ru.LearnUp.event.*.*(*))")
    public void collIn() {
    }

    /*LogMethod - все методы помеченные данной аннотацией должны логгировать имя метода параметры метода и возвращаемое значение*/
    @Before("@annotation(ru.LearnUp.annotation.LogMethod)")
    public void BeforeAnnotation(@NotNull JoinPoint joinPoint) {
        this.joinPoint = joinPoint;
        log.info("имя метода: {}", joinPoint.getSignature().getName());
        log.info("параметры метода: {}", Arrays.stream(joinPoint.getArgs()).toArray());
        log.info("возвращаемое значение: {}", joinPoint.getTarget());
    }
    /* @Before("collIn()")
    public void beforeColl(JoinPoint joinPoint) {
        Object[] argsArr = joinPoint.getArgs();
        for (Object o : argsArr) {
            log.info("args {}", o.toString());
        }
    }*/

  /*  @Around("callIn()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Before execute {}", joinPoint.toString());
        Object result = joinPoint.proceed();
        log.info("After execute {}", joinPoint.toString());
        return result;
    }*/
}

