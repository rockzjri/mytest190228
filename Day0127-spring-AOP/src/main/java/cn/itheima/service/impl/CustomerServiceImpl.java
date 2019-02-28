package cn.itheima.service.impl;

import cn.itheima.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

    @Override
    public void saveCustomer() {

        System.out.println("保存客户。");

    }

    @Override
    public void findCustomerById(Integer id) {
        System.out.println("根据客户Id查询客户。客户Id："+id);
    }
}
