package cn.itcast.controller;

import cn.itcast.dao.CustomerDao;
import cn.itcast.service.CustomerService;
import cn.itcast.service.impl.CustomerServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerController {

    public static void main(String[] args) {


//        CustomerServiceImpl service = new CustomerServiceImpl();
//        service.saveCustomer();

        //加载配置文件，创建spring容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        //获取service对象
        CustomerService Service =(CustomerService) applicationContext.getBean("customerService");

        //CustomerDao customerDao =(CustomerDao) applicationContext.getBean("customerDao");

        //对象调用方法
        Service.saveCustomer();

       // customerDao.saveCustomer();

    }
}
