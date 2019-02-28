package cn.itrock.ssm.dao;

import cn.itrock.ssm.po.Permission;
import cn.itrock.ssm.po.Role;

import java.util.List;

public interface RoleDao {

    //查询全部订单列表
   List<Role> findAllRoles();

   //添加role新信息
    void saveRole(Role role);


    //----分别配权限内容--------------------------------------------

    //根据id查询role
    Role findRoleAndPermissionsById(Long roleId);

    //查询所有Permission
    List<Permission> findAllPermissions();

    //删除旧权限配置关系byid
    void delRoleAndPermission(Long roleId);

    //添加新的权限配置关系
    void addRoleAndPermission(Long[] RoleIdAndPermissionId);
}
