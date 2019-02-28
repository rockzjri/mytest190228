package cn.itheima.bank.service.impl;

import cn.itheima.bank.dao.AccountDao;
import cn.itheima.bank.po.Account;

public class AccountServiceImpl {
    // 定义账户dao对象
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 根据账户id查询账户
     */
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    /**
     * 转账操作
     * 参数：
     * sourceName：转出账户名称
     * destName：转入账户名称
     * money：转账金额
     */
    public void transfer(String sourceName, String destName, Float money) {

        // 1.查询转出账户
        Account sourceAccount = accountDao.findAccountByName(sourceName);
        // 2.查询转入账户
        Account destAccount = accountDao.findAccountByName(destName);
        // 3.转出账户-money
        sourceAccount.setMoney(sourceAccount.getMoney()-money);
        // 4.转入账户+money
        destAccount.setMoney(destAccount.getMoney()+money);
        // 5.更新转出账户
        accountDao.updateAccount(sourceAccount);
        // 6.更新转入账户
        accountDao.updateAccount(destAccount);
    }

}
