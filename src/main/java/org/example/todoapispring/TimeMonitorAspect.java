package org.example.todoapispring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorAspect {

    @Around("@annotation(TimeMonitor)")
    public void logTime(ProceedingJoinPoint joinPoint){
        long start=System.currentTimeMillis(); // start time of code

        try{
            // Execute the join point
            joinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("Something went wrong during execution");
        }
        finally {
            // find end time of code after executing join point
            long end=System.currentTimeMillis();

            System.out.println("Total execution time:"+(end-start));
        }

    }
}
