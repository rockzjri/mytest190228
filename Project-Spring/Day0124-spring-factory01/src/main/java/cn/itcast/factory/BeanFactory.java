package cn.itcast.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {

    private static BeanFactory beanFactory;

    private static Properties pro;

    public  BeanFactory() {
    }

    static {

        beanFactory = new BeanFactory();


        pro = new Properties();

        try {

            InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");

            pro.load(inputStream);


        } catch (IOException e) {
            System.out.println("加载properties文件失败：" + e.getMessage());
        }

    }

    public static BeanFactory getbeanFactory() {

        return beanFactory;

    }

//    public Costomerdao getcostomerdao(){
//
//        return new Costomerdaoimpl();
//    }

    //通过某类名将该类实例化；

    public Object getbean(String name) {

        Object obj = null;

        String property = pro.getProperty(name);


        try {

            obj = Class.forName(property).newInstance();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return obj;
    }


}
