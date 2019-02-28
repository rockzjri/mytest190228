package cn.itheima.service;

import cn.itheima.po.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAllCustomers();
}
