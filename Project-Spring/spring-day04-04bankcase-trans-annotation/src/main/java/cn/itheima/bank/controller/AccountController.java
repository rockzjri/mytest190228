package cn.itheima.bank.controller;

import cn.itheima.bank.config.SpringConfiguration;
import cn.itheima.bank.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 账户controller
 */
public class AccountController {

    public static void main(String[] args) {
        // 1.加载spring配置类，创建spring的容器
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        // 2.获取账户service对象
        AccountService accountService =(AccountService) context.getBean("accountService");

        // 3.转账操作：小明给小花转账200块钱
        accountService.transfer("小明","小花",200f);
    }
}
