package cn.itheima.dao;

import cn.itheima.po.QueryVo;
import cn.itheima.po.User;
import org.junit.Test;

import java.util.List;

/**
 * 用户mapper接口
 */
public interface UserMapper {

    /**
     * 使用pojo包装类型，实现根据用户明模糊查询用户
     */
    List<User> queryUserByQueryVo(QueryVo queryVo);

}
