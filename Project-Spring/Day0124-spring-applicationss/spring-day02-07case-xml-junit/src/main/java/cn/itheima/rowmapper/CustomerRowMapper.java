package cn.itheima.rowmapper;

import cn.itheima.po.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 客户结果集映射对象
 */
public class CustomerRowMapper implements RowMapper<Customer>{

    /**
     *while(rs.next()){
     *     rs.getxxx("");
     *}
     */
    public Customer mapRow(ResultSet rs, int index) throws SQLException {

        // 创建客户对象
        Customer customer = new Customer();

        customer.setCustId(rs.getLong("cust_id"));
        customer.setCustName(rs.getString("cust_name"));
        customer.setCustSource(rs.getString("cust_source"));
        customer.setCustIndustry(rs.getString("cust_industry"));
        customer.setCustLevel(rs.getString("cust_level"));
        customer.setCustAddress(rs.getString("cust_address"));
        customer.setCustPhone(rs.getString("cust_phone"));

        return customer;
    }
}
