package cn.itcast.dao.impl;

import cn.itcast.dao.CustomerDao;

import java.util.Date;

public class SetDaoImpl implements CustomerDao {

    private int id;
    private String name;
    private Integer age;
    private  String sex;
    private Date birthday;


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public void saveCustomer() {

        System.out.println("编号："+id+"；姓名："+name+";年龄："+age+"；性别："+sex+"；生日："+birthday);

    }
}
