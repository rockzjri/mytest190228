package cn.itheima.dao;

import cn.itheima.po.Customer;

import java.util.List;

/**
 * 客户dao接口
 */
public interface CustomerDao {

    /**
     * 查询全部客户列表数据
     */
    List<Customer> findAllCustomers();
}
