package cn.itcast.dao.impl;

import cn.itcast.dao.CustomerDao;

import java.util.Date;

public class ConstructorDaoImpl implements CustomerDao {


    private int id;
    private String name;
    private  String sex;
    private Date birthday;

    public ConstructorDaoImpl(int id, String name, String sex, Date birthday) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }

    @Override
    public void saveCustomer() {

        System.out.println("编号："+id+"；姓名："+name+"；性别："+sex+"；生日："+birthday);



    }
}
