package cn.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 编写spring框架配置类
 *
 * @Configuration注解：标记当前类是一个spring的配置类
 *
 * @ComponentScan注解：配置包扫描
 *
 * @EnableAspectJAutoProxy注解：开启spring对象注解aop的支持。
 * 相当于xml配置中的<aop:aspectj-autoproxy/>标签
 *
 */
@Configuration
@ComponentScan(value = {"cn.itheima"})
@EnableAspectJAutoProxy
public class SpringConfiguration {
}
