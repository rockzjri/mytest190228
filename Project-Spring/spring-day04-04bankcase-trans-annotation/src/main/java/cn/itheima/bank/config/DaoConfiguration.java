package cn.itheima.bank.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 持久层的dao配置类
 */
public class DaoConfiguration {

    /**
     * 创建JdbcTemplate
     */
    @Bean(value = "jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(DataSource dataSource){

        // 创建JdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        return jdbcTemplate;
    }

    /**
     * 创建数据源DataSource
     */
    @Bean(value = "dataSource")
    public DataSource createDataSource(){
        // 创建Druid数据源对象
        DruidDataSource dataSource = new DruidDataSource();

        // 设置连接数据库的四个基本要素
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/3_spring");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");

        // 设置数据源的公共属性
        dataSource.setInitialSize(6);
        dataSource.setMinIdle(3);
        dataSource.setMaxActive(50);
        dataSource.setMaxWait(60000);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);

        return dataSource;

    }
}
