package cn.itheima.bank.service.impl;

import cn.itheima.bank.dao.AccountDao;
import cn.itheima.bank.po.Account;
import cn.itheima.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 账户service实现类
 */
@Service("accountService")
public class AccountServiceImpl  implements AccountService{

    // 定义持久层dao接口
    @Autowired
    private AccountDao accountDao;

    // 定义事务管理模版对象
    @Autowired
    private TransactionTemplate transactionTemplate;

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
    public void transfer(final String sourceName,final  String destName,final Float money) {

        // 1.定义事务回调接口
        TransactionCallbackWithoutResult tcwr = new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {

                // 放置业务代码
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
                int i=1/0;

                // 6.更新转入账户
                accountDao.updateAccount(destAccount);
            }
        };

        // 2.通过事务管理模版执行
        transactionTemplate.execute(tcwr);



    }
}
