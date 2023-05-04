package ru.otus.spring.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
    @Before("execution(* ru.otus.spring.service.QuizService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println(
                "logBefore:  "
                        + joinPoint.getSignature().getName()
        );
    }
}
