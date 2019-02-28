package cn.itheima.service.impl;

import cn.itheima.dao.CustomerDao;
import cn.itheima.dao.impl.CustomerDaoimpl;
import cn.itheima.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;
   // private CustomerDaoimpl customerDao;

    //  private CustomerDao customerDao1 = new CustomerDaoimpl();


    @Override
    public void saveCustomer() {

        customerDao.saveCustomer();
    }

}
