package cn.itheima.service;

import java.net.Inet4Address;

/**
 * 客户service对象
 */
public interface CustomerService {

    /**
     * 保存客户
     */
    void saveCustomer();

    /**
     * 根据客户Id查询客户
     */
    void findCustomerById(Integer id);
}
