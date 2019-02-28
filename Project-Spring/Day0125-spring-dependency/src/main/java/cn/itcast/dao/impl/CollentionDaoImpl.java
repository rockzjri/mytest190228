package cn.itcast.dao.impl;

import cn.itcast.dao.CustomerDao;

import java.util.*;

public class CollentionDaoImpl implements CustomerDao {

    private String[] array;
    private List<String> list;
    private Set<String> set;
    private Map<String,String> map;
    private Properties prop;

    public void setArray(String[] array) {
        this.array = array;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    @Override
    public void saveCustomer() {
        System.out.println(array !=null? Arrays.asList(array):"");
        System.out.println(list);
        System.out.println(set);
        System.out.println(map);
        System.out.println(prop);

    }
}
