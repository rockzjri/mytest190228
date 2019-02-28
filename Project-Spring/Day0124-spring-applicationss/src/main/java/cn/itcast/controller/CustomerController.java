package cn.itcast.controller;

import cn.itcast.dao.CustomerDao;
import cn.itcast.service.CustomerService;
import cn.itcast.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class CustomerController {

    public static void main(String[] args) {


//        CustomerServiceImpl service = new CustomerServiceImpl();
//        service.saveCustomer();

        // 加载配置文件，创建spring容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

//        获取service对象
//         CustomerService Service =(CustomerService) applicationContext.getBean("customerService");

        System.out.println("加载这里呢");

        CustomerDao customerDao = (CustomerDao) applicationContext.getBean("staticFactory");

//        对象调用方法
//         Service.saveCustomer();

        customerDao.saveCustomer();

        applicationContext.close();


        //BeanFactory：什么时 候使用对象，什么时候创建配置文件中的对象。采用延迟创建的思想

//        ClassPathResource resource = new ClassPathResource("bean.xml");
//
//        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(resource);
//
//        System.out.println("这里先加载啦  ");
//
//        CustomerDao cDao = (CustomerDao) xmlBeanFactory.getBean("customerDao");
//
//        cDao.saveCustomer();

    }
}
