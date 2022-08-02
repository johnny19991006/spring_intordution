package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
//@Component 이거누르면 aop적용됨(ms단위로 측정 가능.)
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint)throws Throwable{
        long start=System.currentTimeMillis();
        System.out.println("START:" + joinPoint.toString());
        try{
            return joinPoint.proceed();
        }finally{
            long finish = System.currentTimeMillis();
            long timeMs= finish - start;
            System.out.println("END:"+ joinPoint.toString() +" "+ timeMs+"ms");
        }
    }
}
