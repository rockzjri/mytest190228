package cn.itheima.dao.impl;

import cn.itheima.dao.CustomerDao;
import cn.itheima.po.Customer;
import cn.itheima.rowmapper.CustomerRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 客户dao实现类
 */
public class CustomerDaoImpl implements CustomerDao {

    // 定义JdbcTemplate
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 查询全部客户列表数据
     */
    public List<Customer> findAllCustomers() {

        List<Customer> list = jdbcTemplate.
                query("select * from cst_customer", new CustomerRowMapper());

        return list;
    }
}
