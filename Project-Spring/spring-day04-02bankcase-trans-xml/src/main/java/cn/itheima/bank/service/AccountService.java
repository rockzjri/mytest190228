package cn.itheima.bank.service;

import cn.itheima.bank.po.Account;

/**
 * 账户service接口
 */
public interface AccountService {

    /**
     * 根据账户Id查询账户
     */
    Account findAccountById(Integer accountId);

    /**
     * 转账操作(谁给谁转账，转多少钱)
     *
     * 参数说明：
     *  sourceName：转出账户
     *  destName:转入账户
     *  money：转账金额
     */
    void transfer(String sourceName,String destName,Float money);
}
