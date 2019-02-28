package cn.itheima.dao;

import cn.itheima.po.Customer;

import java.util.List;

public interface CustomerDao {

  List<Customer> findAllCustomers();


}
