package cn.itheima.dao.impl;

import cn.itheima.dao.CustomerDao;
import org.springframework.stereotype.Component;

/**
 * 客户dao实现类
 */
@Component("customerDao")
public class CustomerDaoImpl implements CustomerDao{

    /**
     * 保存客户
     */
    public void saveCustomer() {
        System.out.println("保存客户。");
    }
}
