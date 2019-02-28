package cn.itcast.factory;

import cn.itcast.dao.CustomerDao;
import cn.itcast.dao.impl.CustomerDaoImpl;

public class StaticFactory {

    public static CustomerDao createCustomerDao(){
        System.out.println("【静态】方法打印");

        return new CustomerDaoImpl();
    }
}
