package cn.itheima.controller;

import cn.itheima.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 客户controller对象
 */
public class CustomerController {

    public static void main(String[] args) {
        // 1.加载spring配置文件，创建spring容器
        /**
         * classpath: 表示从类的根路径下加载配置文件，可以加可以不加
         * spring框架它建议我们加上
         */
        //ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");

        // 2.获取客户service对象
        /**
         * 学习创建对象相关的注解：@Component。衍生的三个注解：@Controller,@Service，@Repository
         */
       // CustomerService customerService = (CustomerService)context.getBean("customerService");

        /**
         * 学习设置bean的作用范围相关的注解：@Scope
         */
       /* CustomerService customerService = (CustomerService)context.getBean("customerService");
        CustomerService customerService1 = (CustomerService)context.getBean("customerService");

        System.out.println(customerService==customerService1);
        System.out.println(customerService.hashCode());
        System.out.println(customerService1.hashCode());*/

        /**
         * 学习注入数据相关的注解：@Autowired、@Qualifier、@Resource、@Value
         */
        //CustomerService customerService = (CustomerService)context.getBean("customerService");

        /**
         * 学习与bean的生命周期相关的注解：@PostConstruct/@PreDestroy
         *
         */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");
        CustomerService customerService = (CustomerService)context.getBean("customerService");

        // 3.保存客户
        customerService.saveCustomer();

        // 销毁容器
        context.close();

    }
}
