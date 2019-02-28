package cn.itcast.dao.impl;

import cn.itcast.dao.CustomerDao;

public class CustomerDaoImpl implements CustomerDao {

    public CustomerDaoImpl(){
        System.out.println("谁先加载？？");
    }


    public void init(){
        System.out.println("正在启动执行");

    }

    public void destory(){
        System.out.println("正在销毁文件");
    }


    @Override
    public void saveCustomer() {
        System.out.println("保存客户，对，留住他");
    }
}
