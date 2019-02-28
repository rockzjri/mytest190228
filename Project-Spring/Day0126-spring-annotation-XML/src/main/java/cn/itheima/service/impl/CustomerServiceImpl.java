package cn.itheima.service.impl;

import cn.itheima.dao.CustomerDao;
import cn.itheima.po.Customer;
import cn.itheima.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

private CustomerDao customerDao;



public void setCustomerDao(CustomerDao customerDao){
    this.customerDao=customerDao;
}

    @Override
    public List<Customer> findAllCustomers() {

        return customerDao.findAllCustomers();
    }
}
