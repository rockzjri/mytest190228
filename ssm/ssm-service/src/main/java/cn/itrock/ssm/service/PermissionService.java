package cn.itrock.ssm.service;

import cn.itrock.ssm.po.Permission;
import com.github.pagehelper.PageInfo;



public interface PermissionService {

    //查询全部订单列表
    PageInfo<Permission> findAllPermission(Integer pageNum,Integer pageSize);



    //添加role新信息
    void savePermission(Permission permission);

    //删除权限byid
    void delPermissionById(Long id);
}
