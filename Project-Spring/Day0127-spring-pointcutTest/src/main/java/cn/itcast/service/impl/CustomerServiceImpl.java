package cn.itcast.service.impl;

import cn.itcast.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public void saveCustomer() {
        System.out.println("保存客户0127");
    }

    @Override
    public void findCustomerId(Integer id) {

        System.out.println("客户编号："+id);
    }
}
