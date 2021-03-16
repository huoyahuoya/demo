package com.example.demo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WzcgLogAspect {

    @Pointcut("@annotation(com.example.demo.aspect.WzcgLog)")
    public void pointCut(){
    }

    @Before("pointCut() && @annotation(wzcgLog)")
    public void before(JoinPoint joinPoint,WzcgLog wzcgLog){
        System.out.println("wrz_log opsValue = " + wzcgLog.opsValue());
        System.out.println("wrz_log remarkField = " + wzcgLog.remarkField());
        System.out.println("wrz_log isDel = " + wzcgLog.isDel());
        System.out.println("wrz_log onlyLogOnSuccess = " + wzcgLog.onlyLogOnSuccess());

        Object[] args = joinPoint.getArgs();
        if(args != null && args.length > 0){
            MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
            String[] paramNames = methodSignature.getParameterNames();
            int idx = 0;
            for (String paramName : paramNames){
                System.out.println("wrz_log paramName = " + paramName);
                System.out.println("wrz_log args[" + idx +" ] = " + String.valueOf(args[idx]));
                idx++;
            }
        }
    }

    @AfterReturning(pointcut = "pointCut() && @annotation(wzcgLog)", returning = "res")
    public void afterReturning(WzcgLog wzcgLog, Object res){
        System.out.println("wrz_log afterReturning");
    }
}
