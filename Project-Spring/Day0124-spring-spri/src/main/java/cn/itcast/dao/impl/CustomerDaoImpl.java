package cn.itcast.dao.impl;

import cn.itcast.dao.CustomerDao;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public void saveCustomer() {
        System.out.println("保存客户，对，留住他");
    }
}
