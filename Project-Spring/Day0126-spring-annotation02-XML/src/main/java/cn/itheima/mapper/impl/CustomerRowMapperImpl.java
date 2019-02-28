package cn.itheima.mapper.impl;

import cn.itheima.po.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapperImpl implements RowMapper {


    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {

        Customer customer = new Customer();

        customer.setCustId(rs.getLong("cust_id"));
        customer.setCustName(rs.getNString("cust_name"));

        customer.setCustSource(rs.getString("cust_source"));
        customer.setCustIndustry(rs.getString("cust_industry"));

        customer.setCustLevel(rs.getString("cust_level"));
        customer.setCustAddress(rs.getString("cust_address"));
        customer.setCustPhone(rs.getString("cust_phone"));



        return customer;
        }
}
