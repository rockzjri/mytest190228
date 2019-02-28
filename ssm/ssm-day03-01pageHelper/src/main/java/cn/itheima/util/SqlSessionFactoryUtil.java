package cn.itheima.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * SqlSessionFactory工具类
 */
public class SqlSessionFactoryUtil {

    // 声明SqlSessionFactory对象
    private static SqlSessionFactory sqlSessionFactory;

    // 静态代码块初始化
    static {

        try {
            // 1.加载主配置文件
            InputStream inputStream = inputStream = Resources.getResourceAsStream("sqlMapConfiG.xml");

            // 2.读取主配置文件内容，得到SqlSessionFactory对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            /**
             * SqlSessionFactory：
             *      1.它是mybatis框架的核心对象
             *      2.它是线程安全的
             *      3.一个项目中通常只需要一个（单例设计模式的应用）
             */
            sqlSessionFactory = builder.build(inputStream);
        } catch (IOException e) {
            System.out.println("初始化SqlSessionFactory对象失败，"+e.getMessage());
        }

    }

    /**
     * 提供一个公有静态的方法，获取SqlSessionFactory
     */
    public static  SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

}
