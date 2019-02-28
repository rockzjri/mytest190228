package cn.itheima.test;

import cn.itheima.po.Customer;
import cn.itheima.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 学习spring整合junit测试
 *
 * 整合步骤：
 *      第一步：导入junit单元测试框架包
 *      第二步：导入spring-test测试模块包
 *      第三步：通过@RunWith注解，把junit单元测试类，替换成spring提供的测试类（SpringJUint4ClassRunner）
 *      第四步：通过@ContextConfiguration注解，加载spring的配置文件
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:bean.xml"})
public class SpringJunitTest {

    /**
     * 测试查询全部客户列表数据
     *
     * 问题：
     *      1.每一个测试的方法，都需要手动加载spring配置文件，手动获取service对象。麻烦！！！
     *
     * 期望：
     *      1.能不能让框架自动加载spring配置文件，自动注入service对象。
     */
    @Test
    public void findAllCustomersTest(){
        // 1.加载spring的配置文件，创建spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");

        // 2.获取客户service对象
        CustomerService customerService = (CustomerService)context.getBean("customerService");

        // 3.查询客户列表数据
        List<Customer> list = customerService.findAllCustomers();
        for(Customer c:list){
            System.out.println(c);
        }
    }

    /**
     * 测试方式二：
     */
    @Autowired
    private CustomerService customerService;

    @Test
    public void findAllCustomers_2Test(){

        // 3.查询客户列表数据
        List<Customer> list = customerService.findAllCustomers();
        for(Customer c:list){
            System.out.println(c);
        }
    }
}
