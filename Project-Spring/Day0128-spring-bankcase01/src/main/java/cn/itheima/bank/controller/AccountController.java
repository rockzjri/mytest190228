package cn.itheima.bank.controller;

import cn.itheima.bank.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountController {

    public static void main(String[] args) {
        // 1.加载bean.xml文件，创建spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");

        // 2.获取账户service对象
        AccountService service = (AccountService) context.getBean("accountService");

        // 3.小明给小花转账200块钱
        service.transfer("小明","小花",200f);
    }

}
