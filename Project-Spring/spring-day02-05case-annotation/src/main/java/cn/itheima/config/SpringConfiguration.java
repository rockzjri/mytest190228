package cn.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
public class SpringConfiguration {

    /**
     *  <!--配置JdbcTemplate对象-->
     * <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
     * <!--注入数据源对象-->
     * <property name="dataSource" ref="dataSource"></property>
     * </bean>
     *
     * 解读以上的配置信息：
     *      1.创建一个JdbcTemplate对象
     *      2.需要注入一个数据源对象DataSource
     *      3.需要把该对象放入spring的IOC容器中，名称叫做jdbcTemplate
     *
     *  @Bean注解：
     *          作用：把方法的返回值，放入spring的容器
     *          属性：
     *              value：给bean取一个名称
     *              name：给bean取一个名称
     *
     */
    @Bean(value = "jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(DataSource dataSource){

        // 创建JdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        return jdbcTemplate;
    }

    /**
     *  <!--配置数据源对象-->
     <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
     <!--注入连接数据库的四个基本要素-->
     <property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
     <property name="url" value="jdbc:mysql://127.0.0.1:3306/3_spring"></property>
     <property name="username" value="root"></property>
     <property name="password" value="admin"></property>

     <!--连接池的公共属性-->
     <!-- 初始化连接数量 -->
     <property name="initialSize" value="6" />
     <!-- 最小空闲连接数 -->
     <property name="minIdle" value="3" />
     <!-- 最大并发连接数(最大连接池数量) -->
     <property name="maxActive" value="50" />
     <!-- 配置获取连接等待超时的时间 -->
     <property name="maxWait" value="60000" />
     <!-- 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 -->
     <property name="timeBetweenEvictionRunsMillis" value="60000" />
     </bean>
     */
    @Bean(value = "dataSource")
    public DataSource createDataSource(){
        // 创建数据源对象
        DruidDataSource dataSource = new DruidDataSource();

        // 注入连接数据库的四个基本要素
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/3_spring");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");

        // 注入连接池的公共属性
        dataSource.setInitialSize(6);
        dataSource.setMinIdle(3);
        dataSource.setMaxActive(50);
        dataSource.setMaxWait(60000);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);

        return dataSource;
    }
}
