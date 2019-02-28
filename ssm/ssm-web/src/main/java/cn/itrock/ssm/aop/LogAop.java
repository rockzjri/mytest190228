package cn.itrock.ssm.aop;

//import cn.itrock.ssm.po.SysLog;
//import cn.itrock.ssm.po.User;
//import cn.itrock.ssm.service.SysLogService;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.UnsupportedEncodingException;
//import java.util.Date;

import cn.itrock.ssm.po.SysLog;
import cn.itrock.ssm.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
@Component("logAop")
@Aspect
public class LogAop {

    //字节码对象
    private Class clazz;

    //方法名
    private String methodName;

    @Autowired
    private SysLogService sysLogService;

    // 请求HttpServletRequest对象
    @Autowired
    private HttpServletRequest Request;


    //前置增强
    @Before("execution(* cn.itrock.ssm.controller..*.*(..))")
    public void beforeLog(JoinPoint jpt) {

        //获取字节码
        clazz = jpt.getClass();

        //获取类名
        String clazzName = clazz.getName();

        // 获取方法名称
        methodName = jpt.getSignature().getName();

        methodName = clazzName + methodName;

    }

    //后置增强
    @After("execution(* cn.itrock.ssm.controller..*.*(..))")
    public void afterLog() {

        SysLog sysLog = new SysLog();

        sysLog.setMethod(methodName);

        sysLog.setIp(Request.getRemoteAddr());

        sysLog.setVisitTime(new Date());

//        sysLog.setUsername("xiaohua");

        //获取用户名
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User principal = (User) authentication.getPrincipal();
        String username = principal.getUsername();
        sysLog.setUsername(username);

        //保存日志
        sysLogService.saveSysLog(sysLog);

//        System.out.println("日志记录文件信息=" + sysLog);


    }


}
//@Component
//@Aspect
//public class LogAop {
//
//    // 目标类的字节码
//    private Class clazz;
//
//    // 目标方法名称
//    private String methodName;
//
//    // 注入HttpServletRequest对象
//    @Autowired
//    private HttpServletRequest httpServletRequest;
//
//    // 注入系统日志service
//    @Autowired
//    private SysLogService sysLogService;
//
//    /**
//     * 前置增强：前置通知
//     * 1.用于获取一些初始化信息
//     *
//     * // 获取目标对象信息的分析：
//     *      1.曾经在环绕通知中，可以通过ProceedJoinPoint获取到目标对象相关信息。该接口对象只能用于环绕通知
//     *      2.在前置通知中，可以通过它的父亲JoinPoint完成相同的工作
//     */
//    @Before("execution(* cn.itrock.ssm.controller..*.*(..))")
//    public void beforeLog(JoinPoint jp){
//
//        // 获取目标对象的字节码
//        clazz= jp.getTarget().getClass();
//        String className=clazz.getName();
//
//        // 获取目标对象的方法名称
//        methodName = jp.getSignature().getName();
//        methodName = className+"."+methodName;
//
//    }
//
//    /**
//     * 后置增强：最终通知
//     * 1.把日志保存数据库
//     */
//    @After("execution(* cn.itrock.ssm.controller..*.*(..))")
//    public void afterLog(){
//
//        // 创建日志对象
//        SysLog sysLog = new SysLog();
//
//        // 设置方法名称
//        sysLog.setMethod(methodName);
//
//        // 设置访问时间
//        sysLog.setVisitTime(new Date());
//
//        // 设置ip地址
//        sysLog.setIp(httpServletRequest.getRemoteAddr());
//
//        // 设置用户名称（从spring security获取数据）
//        // 获取security上下文对象
//        SecurityContext context = SecurityContextHolder.getContext();
//
//        // 获取到认证对象
//        Authentication authentication = context.getAuthentication();
//
//        // 获取主角Principal对象（用户）
//        User user = (User)authentication.getPrincipal();
//
//        sysLog.setUsername(user.getUsername());
//
//        // 保存日志
//        sysLogService.saveSysLog(sysLog);
//
//    }


//}