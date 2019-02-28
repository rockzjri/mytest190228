package cn.itheima.dao.impl;

import cn.itheima.dao.CustomerDao;
import org.springframework.stereotype.Repository;

@Repository("customerDaoimpl1")
public class CustomerDaoimpl01  implements CustomerDao{




    @Override
    public void saveCustomer() {
        System.out.println("保存客户1111");

    }
}
