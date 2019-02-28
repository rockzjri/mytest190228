package cn.itheima.controller;

import cn.itheima.service.CustomerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerController {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");

        CustomerService customerService = (CustomerService) context.getBean("customerService");

        customerService.saveCustomer();

        context.close();

    }

}
