package cn.itheima.bank.dao;

import cn.itheima.bank.po.Account;

/**
 * 账户dao接口
 */
public interface AccountDao {

    /**
     * 根据账户id查询
     */
    Account findAccountById(Integer accountId);

    /**
     * 根据账户名称查询
     */
    Account findAccountByName(String accountName);

    /**
     * 更新账户
     */
    void updateAccount(Account account);
}
