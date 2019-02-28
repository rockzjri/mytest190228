package cn.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class DaoConfiguration {

    @Bean(value = "jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(DataSource dataSource){

        // 创建JdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        return jdbcTemplate;
    }

    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.initialSize}")
    private Integer initialSize;
    @Value("${jdbc.minIdle}")
    private Integer minIdle;
    @Value("${jdbc.maxActive}")
    private Integer maxActive;
    @Value("${jdbc.maxWait}")
    private Integer maxWait;
    @Value("${jdbc.timeBetweenERM}")
    private Integer timeBetweenERM;





    @Bean(value = "dataSource")
    public DataSource createDataSource(){
        // 创建数据源对象
        DruidDataSource dataSource = new DruidDataSource();

        // 注入连接数据库的四个基本要素
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        // 注入连接池的公共属性
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenERM);

        return dataSource;
    }
}
