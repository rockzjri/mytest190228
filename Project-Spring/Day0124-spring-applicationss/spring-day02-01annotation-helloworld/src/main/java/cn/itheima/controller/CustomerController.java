package cn.itheima.controller;

import cn.itheima.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 客户controller对象
 */
public class CustomerController {

    public static void main(String[] args) {
        // 1.加载spring配置文件，创建spring容器
        /**
         * classpath: 表示从类的根路径下加载配置文件，可以加可以不加
         * spring框架它建议我们加上
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");

        // 2.获取客户service对象
        CustomerService customerService = (CustomerService)context.getBean("customerService");

        // 3.保存客户
        customerService.saveCustomer();
    }
}
