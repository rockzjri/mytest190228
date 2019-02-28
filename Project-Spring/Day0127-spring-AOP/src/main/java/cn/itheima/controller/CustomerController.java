package cn.itheima.controller;

import cn.itheima.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerController {
    public static void main(String[] args) {

        // 1.加载spring配置文件，创建spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");

        // 2.获取客户service
        CustomerService customerService = (CustomerService) context.getBean("customerService");

        // 3.保存客户
        customerService.saveCustomer();

    }
}
