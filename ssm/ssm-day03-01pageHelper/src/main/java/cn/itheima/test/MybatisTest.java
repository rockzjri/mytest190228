package cn.itheima.test;

import cn.itheima.dao.UserMapper;
import cn.itheima.po.QueryVo;
import cn.itheima.po.User;
import cn.itheima.util.SqlSessionFactoryUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * PageHelper入门案例程序测试
 */
public class MybatisTest {
    /**
     * 1.不进行分页测试
     */
    @Test
    public void noPageQueryTest(){
        // 1.获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();

        // 2.创建sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取接口的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 4.执行数据库操作
        // 创建pojo包装类型
        QueryVo queryVo = new QueryVo();

        // 创建用户对象
        User user = new User();
        user.setUsername("");

        // 包装用户
        queryVo.setUser(user);

        List<User> list = mapper.queryUserByQueryVo(queryVo);
        for(User u:list){
            System.out.println(u);
        }

        // 5.释放资源
        sqlSession.close();
    }

    /**
     * 分页测试
     */
    @Test
    public void pageQueryTest(){
        // 1.获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();

        // 2.创建sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取接口的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 4.执行数据库操作
        // 创建pojo包装类型
        QueryVo queryVo = new QueryVo();

        // 创建用户对象
        User user = new User();
        user.setUsername("");

        // 包装用户
        queryVo.setUser(user);

        // 设置分页
        /**
         * 设置分页参数方法：startPage()。
         * 参数：
         *      参数一：当前页
         *      参数二：每一页显示大小
         *
         *  细节：
         *      该方法要在目标操作前设置
         */
        PageHelper.startPage(1, 2);// 查询第一页，每一页显示2条记录

        // 目标操作：查询用户数据
        List<User> list = mapper.queryUserByQueryVo(queryVo);

        /**
         * 封装分页结果数据：PageInfo
         */
        PageInfo<User> pageInfo = new PageInfo<User>(list);

        /**
         * 打印结果
         */
        System.out.println("上一页："+pageInfo.getPrePage());
        System.out.println("当前页："+pageInfo.getPageNum());
        System.out.println("下一页："+pageInfo.getNextPage());

        System.out.println("每一页页显示大小："+pageInfo.getPageSize());
        System.out.println("总记录数："+pageInfo.getTotal());
        System.out.println("页数："+pageInfo.getPages());

        // 获取页号：1 2 3 4 5 6
        int[] nums = pageInfo.getNavigatepageNums();
        System.out.print("页号：");
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+",");
        }
        System.out.println();

        // 获取结果集
        System.out.println("结果集数据：");
        List<User> pageList = pageInfo.getList();
        for(User u:pageList){
            System.out.println(u);
        }

        // 5.释放资源
        sqlSession.close();
    }

}
