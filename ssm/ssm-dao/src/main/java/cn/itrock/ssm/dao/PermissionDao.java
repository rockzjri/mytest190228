package cn.itrock.ssm.dao;

import cn.itrock.ssm.po.Permission;


import java.util.List;

public interface PermissionDao {

    //查询全部订单列表
    List<Permission> findAllPermission();

    //添加role新信息
    void savePermission(Permission permission);

    //删除权限byid
    void delPermissionById(Long id);

}
