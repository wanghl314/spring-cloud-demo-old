package com.whl.demo.common.aspect;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class CommonAspect {
    @Autowired
    private Environment environment;

    @Pointcut("execution(* com.whl.demo..controller.*.*(..))")
    private void controllerPointCut() {
    }

    @Pointcut("execution(* com.whl.demo..service..*.*(..))")
    private void servicePointCut() {
    }

    @Around("controllerPointCut()")
    public Object addServerPortToControllerRvt(ProceedingJoinPoint point) throws Throwable {
        Object result = point.proceed();
        System.out.println("addServerPortToControllerRvt: " + point.getTarget());

        if (result instanceof String) {
            result = result + " (controller: server.port=" + this.environment.getProperty("server.port") + ")";
        }
        return result;
    }

    @Around("servicePointCut()")
    public Object addServerPortToServiceRvt(ProceedingJoinPoint point) throws Throwable {
        Object result = point.proceed();
        System.out.println("addServerPortToServiceRvt: " + point.getTarget());

        if (result instanceof String) {
            result = result + " (service: server.port=" + this.environment.getProperty("server.port") + ")";
        }
        return result;
    }

}
