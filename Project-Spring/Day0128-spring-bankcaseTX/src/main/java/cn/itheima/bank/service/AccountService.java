package cn.itheima.bank.service;

import cn.itheima.bank.po.Account;

public interface AccountService {

    /**
     * 根据账户id查询账户
     */
    Account findAccountById(Integer accountId);

    /**
     * 转账操作
     * 参数：
     *      sourceName：转出账户名称
     *      destName：转入账户名称
     *      money：转账金额
     */
    void transfer(String sourceName,String destName,Float money);

}
