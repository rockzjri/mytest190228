package cn.itrock.ssm.service.impl;

import cn.itrock.ssm.dao.UserDao;
import cn.itrock.ssm.po.Role;
import cn.itrock.ssm.po.User;
import cn.itrock.ssm.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    public PageInfo<User> findAllUsers(Integer pageNum, Integer pageSize) {

        //分页
        PageHelper.startPage(pageNum,pageSize);
        //查询list
        List<User> allUsers = userDao.findAllUsers();
        //创建分页对象
        PageInfo<User> userPageInfo = new PageInfo<>(allUsers);

        return userPageInfo;
    }

    //添加新user
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    /**
     * 根据用户id查询用户信息，并且关联查询出用户关联的角色和权限信息
     */
    public User findUserById(Long id) {
        return userDao.findUserById(id);
    }

    //查询用户角色
    public List<Role> findAllRoles() {
        return userDao.findAllRoles();
    }

    //保存新关系
    public void addUserToRole(Long userId, Long[] RoleId) {
        userDao.delUserAndRole(userId);

        for (int i=0;i<RoleId.length;i++){
            Long[] temId={userId,RoleId[i]};
            userDao.addUserToRole(temId);
        }

    }

    public List<User> findUserByName(String username) {
        return userDao.findUserByName(username);
    }
}
