package cn.itheima.service.impl;

import cn.itheima.service.CustomerService;
import org.springframework.stereotype.Service;

/**
 * 客户service实现类
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    /**
     * 保存客户
     */
    public void saveCustomer() {
        System.out.println("保存客户。");
        // 异常
       // int i=1/0;
    }

    /**
     * 根据客户Id查询客户
     *
     * @param id
     */
    public void findCustomerById(Integer id) {
        System.out.println("根据客户Id查询客户："+id);
    }
}
