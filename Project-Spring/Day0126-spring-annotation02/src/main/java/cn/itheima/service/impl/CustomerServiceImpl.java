package cn.itheima.service.impl;

import cn.itheima.dao.CustomerDao;
import cn.itheima.dao.impl.CustomerDaoimpl01;
import cn.itheima.dao.impl.CustomerDaoimpl2;
import cn.itheima.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//@Component("customerService")
@Service("customerService")
@Scope("singleton")
public class CustomerServiceImpl implements CustomerService {

//    @Autowired
//    private CustomerDao customerDao;

//    @Resource(name ="customerDao2")

   @Resource(type = CustomerDaoimpl01 .class)
    private CustomerDao customerDao;

    @Value("11")
    private int id;
    @Value("小花")
    private String name;




    @Override
    public void saveCustomer() {

        System.out.println("编号："+id+"；姓名："+name);


        customerDao.saveCustomer();
    }
    @PostConstruct
    public void init(){
        System.out.println("正在初始化init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("正在销毁");
    }

}
