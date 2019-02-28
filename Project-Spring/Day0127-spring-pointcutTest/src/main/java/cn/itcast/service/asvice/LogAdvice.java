package cn.itcast.service.asvice;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAdvice {

    public void beforeLog(){
        System.out.println("前置通知");
    }

    public void afterReturningLog(){
        System.out.println("后置通知");
    }
    public void afterThrowingLog(){
        System.out.println("异常通知");
    }
    public void afterLog(){
        System.out.println("最终通知");
    }

    public void aroundLog(ProceedingJoinPoint pppj){
        System.out.println("前置");

        try {

        Object[] args = pppj.getArgs();

            Object proceed = pppj.proceed(args);

            System.out.println("后置");

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("异常");
        }
        System.out.println("环绕");
    }

}
