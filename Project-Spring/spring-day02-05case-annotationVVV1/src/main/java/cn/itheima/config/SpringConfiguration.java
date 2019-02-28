package cn.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * spring的配置类，代替bean.xml文件
 *
 * @Configuration注解：标记当前类是一个spring的配置类
 *
 * @ComponentScan注解：配置包扫描，相当于xml配置中的<context:component-scan/>标签
 */
@Configuration
@ComponentScan(value = {"cn.itheima"})
@Import(value = {DaoConfiguration.class})
@PropertySource(value = {"classpath:db.properties"})
public class SpringConfiguration {


}
