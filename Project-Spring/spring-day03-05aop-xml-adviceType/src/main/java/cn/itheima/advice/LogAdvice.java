package cn.itheima.advice;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 记录日志的通知
 */
public class LogAdvice {

    /**
     * 前置通知
     */
    public void beforeLog(){
        System.out.println("【前置通知-】记录用户操作的日志。");
    }

    /**
     * 后置通知
     */
    public void afterReturningLog(){
        System.out.println("【后置通知-】记录用户操作的日志。");
    }

    /**
     * 异常通知
     */
    public void afterThrowingLog(){
        System.out.println("【异常通知-】记录用户操作的日志。");
    }

    /**
     * 最终通知
     */
    public void afterLog(){
        System.out.println("【最终通知-】记录用户操作的日志。");
    }

    /**
     * 环绕通知:
     *      1.环绕通知就是综合了前置-后置-异常-最终通知，它是一种特殊的通知类型，可以手动控制通知的执行
     *原理分析：
     *      1.spring框架针对环绕通知提供了一个接口（ProceedingJoinPoint），作为环绕通知方法的参数，该接口提供了
     *      两个方法：
     *          getArgs():获取目标方法的参数列表
     *          proceed()：回调目标方法。相当于反射技术中的invoke()方法
     *
     */
    public void aroundLog(ProceedingJoinPoint pjp){

        System.out.println("【环绕通知-前置通知-】记录用户操作的日志。");
        try {
            // 获取目标对象的参数列表
            Object[] args = pjp.getArgs();

            // 回调目标方法
            Object retV = pjp.proceed(args);

            System.out.println("【环绕通知-后置通知-】记录用户操作的日志。");

        } catch (Throwable throwable) {
            throwable.printStackTrace();

            System.out.println("【环绕通知-异常通知-】记录用户操作的日志。");
        }

        System.out.println("【环绕通知-最终通知-】记录用户操作的日志。");

    }
}
