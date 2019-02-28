package cn.itheima.dao.impl;

import cn.itheima.dao.CustomerDao;
import cn.itheima.mapper.impl.CustomerRowMapperImpl;
import cn.itheima.po.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Override
    public List<Customer> findAllCustomers() {

       String Sql="select *from cst_customer";

        CustomerRowMapperImpl mapper = new CustomerRowMapperImpl();


        List<Customer> list = jdbcTemplate.query(Sql, mapper);


        return list;


//        List<Customer> list=jdbcTemplate.query("select*from cst_customer",new CustomerRowMapperImpl());
//        return list;
    }
}
