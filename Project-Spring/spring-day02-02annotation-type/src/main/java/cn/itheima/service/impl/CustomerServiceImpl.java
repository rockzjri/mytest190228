package cn.itheima.service.impl;

import cn.itheima.dao.CustomerDao;
import cn.itheima.dao.impl.CustomerDaoImpl;
import cn.itheima.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 客户service实现类
 *
 * 1、创建对象相关的注解：
 *      @Component：
 *          作用：相当于xml配置文件中的bean标签
 *          属性：
 *              value：给bean取一个名称，相当于bean标签id属性
 *              @Component(value="customerService")
 *          细节：
 *              1.value属性可以省略
 *              2.默认使用类的名称首字母小写，作为bean的名称
 *
 *         由@Component注解演化的三个注解：衍生的目的是为了语义更加明确
 *              @Controller：一般用于表现层对象
 *              @Service：一般用于业务层对象
 *              @Repository：一般用于持久层的对象
 *
 *  2.设置bean的作用范围相关的注解：
 *          @Scope:
 *              作用：设置bean的作用范围
 *              属性：
 *                  value：
 *              属性取值：
 *                     singleton：单例。默认值
 *                     prototype：多例
 *                     request：在web项目中，把对象放入request域
 *                     session：在web项目中，把对象放入session域
 *                     globalsession：在web项目中，把对象放入全局会话域
 *
 *
 * 3.注入数据相关的注解：
 *      @Autowired：
 *             作用：默认按照bean的类型注入。byType
 *             细节：
 *                  1.如果在spring容器中，同一个类型（CustomerDao）存在多个对象。首先按照bean的类型注入；
 *                  再按照bean的名称进行匹配，匹配上就注入成功，匹配不上就注入失败。
 *     @Qualifier：
 *          作用：配合@Autowired注解一起使用。在按照bean的类型注入的基础上，再按照指定的bean名称注入
 *          细节：
 *              1.在类的成员变量上，不能单独使用，必须与@Autowired注解一起使用
 *              2.在方法的形参上可以单独使用
 *
 *      @Resource：
 *           作用：默认按照bean的名称注入数据。byName
 *           属性：
 *              name：指定注入的bean的名称
 *              type：指定注入的bean的类型
 *           细节：
 *              1.默认先按照bean的名称注入数据，再按照bean的类型注入数据。
 *
 *      @Value：
 *          作用：给java简单类型注入数据（八种基本类型+字符串String）
 *
 *   4.与bean的生命周期相关的注解：
 *          @PostContruct:
 *              作用：指定初始化执行的方法，相当于xml配置文件中的init-method属性
 *          @PreDestroy：
 *              作用：指定销毁资源的方法，相当于xml配置文件中的destroy-method属性
 *
 */
//@Component("customerService")
@Service("customerService")
@Scope("singleton")
public class CustomerServiceImpl implements CustomerService{

    // 定义客户dao
    /*@Autowired
    @Qualifier("customerDao2")
    private CustomerDao customerDao;*/

   // @Resource(name="customerDao1")
   @Resource(type= CustomerDaoImpl.class)
    private CustomerDao customerDao;

   // 人
    @Value("1")
    private int id;
    @Value("小明")
    private String name;


    /**
     * 保存客户
     */
    public void saveCustomer() {
        System.out.println("id="+id+",name="+name);
        customerDao.saveCustomer();
    }

    /**
     * 初始化执行的方法
     */
    @PostConstruct
    public void init(){
        System.out.println("执行初始化操作。");
    }

    /**
     * 销毁执行的方法
     */
    @PreDestroy
    public void destroy(){
        System.out.println("执行销毁操作。");
    }
}
