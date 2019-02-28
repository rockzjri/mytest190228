package cn.itheima.bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 事务管理配置类
 */
public class TransactionConfiguration {

    /**
     * 创建事务管理器对象TransactionManager
     */
    @Bean(value = "transactionManager")
    public DataSourceTransactionManager getTransactionManager(DataSource dataSource){
        // 创建事务管理器对象
        DataSourceTransactionManager transactionManager =
                new DataSourceTransactionManager();

        transactionManager.setDataSource(dataSource);

        return transactionManager;
    }
}
