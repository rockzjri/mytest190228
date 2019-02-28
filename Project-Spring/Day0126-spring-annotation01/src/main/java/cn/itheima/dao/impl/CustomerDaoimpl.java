package cn.itheima.dao.impl;

import cn.itheima.dao.CustomerDao;
import org.springframework.stereotype.Component;


@Component("customerDao")
public class CustomerDaoimpl implements CustomerDao {


    @Override
    public void saveCustomer() {
        System.out.println("保存客户");
    }
}
