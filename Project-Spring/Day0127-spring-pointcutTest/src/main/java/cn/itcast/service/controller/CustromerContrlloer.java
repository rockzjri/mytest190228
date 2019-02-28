package cn.itcast.service.controller;


import cn.itcast.service.CustomerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustromerContrlloer {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");

        CustomerService customerService = (CustomerService)context.getBean("customerService");

        customerService.saveCustomer();

    }
}
