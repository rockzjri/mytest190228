package cn.itheima.service;

import cn.itheima.po.Customer;

import java.util.List;

/**
 * 客户service接口
 */
public interface CustomerService {

    /**
     * 查询全部客户列表数据
     */
    List<Customer> findAllCustomers();
}
