package com.example.demo.aspect;

import com.example.demo.domain.OperationLog;
import com.example.demo.service.OperationService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class interfaceAspect {

    @Autowired
    private OperationService operationService;

    @Pointcut("@annotation(com.example.demo.aspect.LogCollection)")
    public void pointCut(){}

    @Around("pointCut()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        Object obj = null;
        OperationLog opsLog = new OperationLog();
        opsLog.setId(1);
        System.out.println("操作记录采集-开始");
        before(proceedingJoinPoint,opsLog);
        try {
            obj = proceedingJoinPoint.proceed();
            System.out.println("wrz_log proceed");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        methodAfterReturning(proceedingJoinPoint,opsLog);

        return "This is doAroundAdvice";

    }

    private void methodAfterReturning(JoinPoint joinPoint, OperationLog opsLog) {
        System.out.println("wrz_log methodAfterReturning");
        operationService.save(opsLog);
    }

    private void before(JoinPoint joinPoint, OperationLog opsLog) {
        System.out.println("wrz_log before");
        LogCollection logCollection = AnnotationUtils.getAnnotation(((MethodSignature)joinPoint.getSignature()).getMethod(), LogCollection.class);
        if ("del".equals(logCollection.value())){
            opsLog.setStr("This is del");
        } else {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            String uri = attributes.getRequest().getServletPath();
            opsLog.setStr("The uri = " + uri);
        }
    }


}