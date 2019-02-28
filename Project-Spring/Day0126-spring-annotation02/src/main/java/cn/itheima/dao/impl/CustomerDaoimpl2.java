package cn.itheima.dao.impl;

import cn.itheima.dao.CustomerDao;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;


//@Component("customerDao")
//@Controller("customerDao")
@Repository("customerDaoimpl2")
public class CustomerDaoimpl2 implements CustomerDao {


    @Override
    public void saveCustomer() {
        System.out.println("保存客户2222");
    }
}
