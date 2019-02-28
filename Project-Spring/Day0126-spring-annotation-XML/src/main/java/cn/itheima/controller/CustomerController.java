package cn.itheima.controller;

import cn.itheima.po.Customer;
import cn.itheima.service.CustomerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CustomerController {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");

        CustomerService customerService = (CustomerService) context.getBean("customerService");

        List<Customer> list = customerService.findAllCustomers();

        for (Customer customer : list) {
            System.out.println(customer);
        }

        context.close();

    }

}
