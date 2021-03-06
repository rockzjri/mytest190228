package cn.itheima.controller;

import cn.itheima.config.SpringConfiguration;
import cn.itheima.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 客户controller
 */
public class CustomerController {

    public static void main(String[] args) {
        // 1.加载spring的配置类，创建spring容器
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        // 2.获取客户service对象
        CustomerService customerService = (CustomerService)context.getBean("customerService");

        // 3.保存客户操作
        customerService.saveCustomer();

        // 根据客户Id查询客户
        //customerService.findCustomerById(1);

    }
}
