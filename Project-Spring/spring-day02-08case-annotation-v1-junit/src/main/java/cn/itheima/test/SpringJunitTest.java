package cn.itheima.test;

import cn.itheima.config.SpringConfiguration;
import cn.itheima.po.Customer;
import cn.itheima.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 学习spring整合junit
 *
 * 整合步骤：
 *      第一步：导入junit单元测试框架包
 *      第二步：导入spring-test测试模块包
 *      第三步：通过@RunWith注解，把junit的测试类，换成spring提供的测试类（SpringJUnit4ClassRunner）
 *      第四步：通过@ContextConfiguration注解，加载spring配置类
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SpringConfiguration.class})
public class SpringJunitTest {

    // 注入客户service对象
    @Autowired
    private CustomerService customerService;

    /**
     * 测试查询全部客户列表数据
     */
    @Test
    public void  findAllCustomersTest(){

        // 1.查询数据库列表
        List<Customer> list = customerService.findAllCustomers();

        for(Customer c:list){
            System.out.println(c);
        }

    }
}
