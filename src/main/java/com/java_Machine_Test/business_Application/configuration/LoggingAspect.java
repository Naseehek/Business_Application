package com.java_Machine_Test.business_Application.configuration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.java_Machine_Test.business_Application..*(..))\"")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();
        logger.info("method {} invoked with args : {}", methodName, args);

        long startTime = System.currentTimeMillis();
        Object results;

        try {
            results = joinPoint.proceed();
        }catch (Exception e){
            logger.error("Exception in method {}: {}", methodName, e.getMessage());
            throw e;
        }

        long elapsedTime = System.currentTimeMillis() - startTime;
        logger.info("Method {} executed in {} ms and returned: {}", methodName, elapsedTime, results);

        return results;
    }

}
