package cn.itheima.bank.dao.impl;

import cn.itheima.bank.dao.AccountDao;
import cn.itheima.bank.po.Account;
import cn.itheima.bank.rowmapper.AccountRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccountDaoImpl implements AccountDao {
    // 定义JdbcTemplate对象
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 根据账户id查询账户
     */
    public Account findAccountById(Integer accountId) {
        List<Account> list = jdbcTemplate.query("select * from account where id=?",
                new AccountRowMapper(), accountId);

        return list.isEmpty()?null:list.get(0);
    }

    /**
     * 根据账户名称查询账户
     */
    public Account findAccountByName(String accountName) {
        List<Account> list = jdbcTemplate.query("select * from account where name=?",
                new AccountRowMapper(), accountName);

        if(list.isEmpty()){
            return null;
        }

        // 银行帐号名称必须唯一
        if(list.size()>1){
            throw new RuntimeException("账户不唯一异常，请检查！");
        }

        return list.get(0);
    }

    /**
     * 更新账户
     */
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set money=? where id=?",
                account.getMoney(),account.getId());
    }

}
