package cn.itheima.controller;

import cn.itheima.config.SpringConfiguration;
import cn.itheima.po.Customer;
import cn.itheima.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 客户controller对象
 */
public class CustomerController {

    public static void main(String[] args) {
        // 1.加载spring的配置类，创建spring容器
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        // 2.获取客户service对象
        CustomerService customerService = (CustomerService)context.getBean("customerService");

        // 3.查询客户列表数据
        List<Customer> list = customerService.findAllCustomers();
        for(Customer c:list){
            System.out.println(c);
        }
    }
}
