package cn.itheima.bank.dao.impl;

import cn.itheima.bank.dao.AccountDao;
import cn.itheima.bank.po.Account;
import cn.itheima.bank.rowmapper.AccountRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 账户dao实现类
 */
public class AccountDaoImpl  implements AccountDao{

    // 定义JdbcTemplate
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 根据账户id查询
     *
     * @param accountId
     */
    public Account findAccountById(Integer accountId) {

        List<Account> list = jdbcTemplate.query("select * from account where id=?", new AccountRowMapper(), accountId);


        return list.isEmpty()?null:list.get(0);
    }

    /**
     * 根据账户名称查询
     *
     * @param accountName
     */
    public Account findAccountByName(String accountName) {

        List<Account> list = jdbcTemplate.query("select * from account where name =?", new AccountRowMapper(), accountName);

        // 判断是否为空
        if(list.isEmpty()){
            return null;
        }

        // 判断账户是否唯一
        if(list.size()>1){
            throw new RuntimeException("账户不唯一，请检查！");
        }


        return list.get(0);
    }

    /**
     * 更新账户
     *
     * @param account
     */
    public void updateAccount(Account account) {

        jdbcTemplate.update("update account set money=? where id=?",account.getMoney(),account.getId());

    }
}
