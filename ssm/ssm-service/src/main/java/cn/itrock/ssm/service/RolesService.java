package cn.itrock.ssm.service;

import cn.itrock.ssm.po.Permission;
import cn.itrock.ssm.po.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RolesService {

    // 查询全部订单列表
    // * 改造接口方法：
    // *      1.将返回值类型改成PageHelper插件提供的PageInfo
    // *      2.增加参数当前页：pageNum，页面大小：pageSize

    PageInfo<Role> findAllRoles(Integer pageNum,Integer pageSize);

    //添加新用户
    void saveRole(Role role);


    //根据id查询role
    Role findRoleAndPermissionsById(Long roleId);

    //查询所有Permission
    List<Permission> findAllPermissions();

    //添加新的权限配置关系
    void addRoleAndPermission( Long roleId,Long[] RoleIdAndPermissionId);

}
