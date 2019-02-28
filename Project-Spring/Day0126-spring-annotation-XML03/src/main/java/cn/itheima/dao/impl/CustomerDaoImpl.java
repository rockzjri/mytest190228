package cn.itheima.dao.impl;

import cn.itheima.dao.CustomerDao;
import cn.itheima.mapper.impl.CustomerRowMapperImpl;
import cn.itheima.po.Customer;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

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
