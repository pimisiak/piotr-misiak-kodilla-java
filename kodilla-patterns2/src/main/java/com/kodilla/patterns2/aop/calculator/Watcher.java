package com.kodilla.patterns2.aop.calculator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Aspect
@Component
public class Watcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(Watcher.class);

    @Before(
            value = "execution(* com.kodilla.patterns2.aop.calculator.Calculator.factorial(..))"
            + "&& args(number) && target(object)",
            argNames = "number,object")
    public void logEvent(final BigDecimal number, final Object object) {
        LOGGER.info(String.format("Class: %s, Args: %s", object.getClass().getName(), number));
    }

    @Around(
            value = "execution(* com.kodilla.patterns2.aop.calculator.Calculator.factorial(..))"
    )
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            final long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            final long end = System.currentTimeMillis();
            LOGGER.info(String.format("Time consumed: %d [ms]", end - begin));
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }
}
