package cn.itheima.service.impl;

import cn.itheima.dao.CustomerDao;
import cn.itheima.po.Customer;
import cn.itheima.service.CustomerService;

import java.util.List;

/**
 * 客户service实现类
 */
public class CustomerServiceImpl implements CustomerService {

    // 定义客户dao
    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /**
     * 查询全部客户列表数据
     */
    public List<Customer> findAllCustomers() {
        return customerDao.findAllCustomers();
    }
}
