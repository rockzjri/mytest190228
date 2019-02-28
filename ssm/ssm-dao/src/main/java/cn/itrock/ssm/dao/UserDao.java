package cn.itrock.ssm.dao;

import cn.itrock.ssm.po.Role;
import cn.itrock.ssm.po.User;

import java.util.List;

public interface UserDao {

    //查询所有user数据
   List<User> findAllUsers();

   //添加新用户
    void saveUser(User user);

    //根据id查用户
    User findUserById(Long id);

    //-------------------------------------------------
    //查询role所有
    List<Role> findAllRoles();

    //根据Id删除
    void delUserAndRole(Long userId);

    //保存新的user和role关系
    void addUserToRole(Long[] userToRoleId);

    //查找所有名字
    List<User> findUserByName(String username);

}
