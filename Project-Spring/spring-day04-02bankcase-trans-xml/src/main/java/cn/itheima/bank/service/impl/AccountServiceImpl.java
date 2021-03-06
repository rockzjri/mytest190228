package cn.itheima.bank.service.impl;

import cn.itheima.bank.dao.AccountDao;
import cn.itheima.bank.po.Account;
import cn.itheima.bank.service.AccountService;

/**
 * 账户service实现类
 */
public class AccountServiceImpl  implements AccountService{

    // 定义持久层dao接口
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 根据账户Id查询账户
     *
     * @param accountId
     */
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    /**
     * 转账操作(谁给谁转账，转多少钱)
     * <p>
     * 参数说明：
     * sourceName：转出账户
     * destName:转入账户
     * money：转账金额
     *
     * @param sourceName
     * @param destName
     * @param money
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

        /**
         * 不好意思，此时不知道是谁那么不小心，把服务器的网线给踢断了，导致发生了意外！！！
         */
        //int i=1/0;

        // 6.更新转入账户
        accountDao.updateAccount(destAccount);
    }
}
