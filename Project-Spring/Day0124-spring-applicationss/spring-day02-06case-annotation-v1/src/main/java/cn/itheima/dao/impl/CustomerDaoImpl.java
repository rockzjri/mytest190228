package cn.itheima.dao.impl;

import cn.itheima.dao.CustomerDao;
import cn.itheima.po.Customer;
import cn.itheima.rowmapper.CustomerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 客户dao实现类
 */
@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

    // 定义JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询全部客户列表数据
     */
    public List<Customer> findAllCustomers() {

        List<Customer> list = jdbcTemplate.
                query("select * from cst_customer", new CustomerRowMapper());

        return list;
    }
}
