package cn.itheima.bank.rowmapper;

import cn.itheima.bank.po.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper {

    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {

        // 创建账户对象
        Account account = new Account();

        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setMoney(rs.getFloat("money"));

        return account;
    }


}
