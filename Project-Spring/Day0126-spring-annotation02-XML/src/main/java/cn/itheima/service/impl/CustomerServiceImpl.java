package cn.itheima.service.impl;

import cn.itheima.dao.CustomerDao;
import cn.itheima.po.Customer;
import cn.itheima.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerServicexml")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;


    @Override
    public List<Customer> findAllCustomers() {

        return customerDao.findAllCustomers();
    }
}
