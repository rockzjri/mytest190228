package cn.itheima.bank.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring的主配置类
 *
 * @EnableTransactionManagement:开启spring对注解事务的支持。相当于xml文件中
 * <tx:annotation-driven/>标签配置
 */
@Configuration
@ComponentScan(value = {"cn.itheima.bank"})
@Import(value = {DaoConfiguration.class,TransactionConfiguration.class})
@EnableTransactionManagement
public class SpringConfiguration {
}
