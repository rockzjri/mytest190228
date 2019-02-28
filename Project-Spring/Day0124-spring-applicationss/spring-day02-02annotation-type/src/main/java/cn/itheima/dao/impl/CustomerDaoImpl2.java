package cn.itheima.dao.impl;

import cn.itheima.dao.CustomerDao;
import org.springframework.stereotype.Repository;

/**
 * 客户dao实现类
 */
//@Component("customerDao")
@Repository("customerDao2")
public class CustomerDaoImpl2 implements CustomerDao{

    /**
     * 保存客户
     */
    public void saveCustomer() {
        System.out.println("保存客户。22222222222222222222222222222");
    }
}
