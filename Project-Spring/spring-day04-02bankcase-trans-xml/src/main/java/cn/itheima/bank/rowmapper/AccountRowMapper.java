package cn.itheima.bank.rowmapper;

import cn.itheima.bank.po.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 账户结果集映射类
 */
public class AccountRowMapper implements RowMapper<Account>{

    /**
     * 封装数据
     */
    public Account mapRow(ResultSet rs, int index) throws SQLException {

        // 创建账户实体类对象
        Account account = new Account();

        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setMoney(rs.getFloat("money"));

        return account;
    }
}
