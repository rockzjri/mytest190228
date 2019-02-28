package cn.itcast.service.impl;

import cn.itcast.dao.CustomerDao;
import cn.itcast.dao.impl.CustomerDaoImpl;
import cn.itcast.service.CustomerService;

//实现类
public class CustomerServiceImpl implements CustomerService {


    //定义客户dao

   private CustomerDao customerDao= new CustomerDaoImpl();


    //继承的方法，实现类
    @Override
    public void saveCustomer() {

        customerDao.saveCustomer();


    }
}
