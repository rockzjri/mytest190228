package cn.itheima.service.impl;

import cn.itheima.dao.CustomerDao;
import cn.itheima.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 客户service实现类
 */
@Component("customerService")
public class CustomerServiceImpl implements CustomerService{

    // 定义客户dao
    @Autowired
    private CustomerDao customerDao;

  /*  public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }*/

    /**
     * 保存客户
     */
    public void saveCustomer() {
        customerDao.saveCustomer();
    }
}
