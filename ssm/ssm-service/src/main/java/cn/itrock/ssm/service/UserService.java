package cn.itrock.ssm.service;

import cn.itrock.ssm.po.Role;
import cn.itrock.ssm.po.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    // 查询全部订单列表
    // * 改造接口方法：
    // *      1.将返回值类型改成PageHelper插件提供的PageInfo
    // *      2.增加参数当前页：pageNum，页面大小：pageSize
    PageInfo<User> findAllUsers(Integer pageNum,Integer pageSize);

    //添加新user
    void saveUser(User user);

    /**
     * 根据用户id查询用户信息，并且关联查询出用户关联的角色和权限信息
     */
    User findUserById(Long id);

    //查询role所有
    List<Role> findAllRoles();
    //添加新用户关系
    void addUserToRole(Long userId,Long[] RoleId);

    //查找所有名字
    List<User> findUserByName(String username);


}
