package cn.itrock.ssm.service.impl;


import cn.itrock.ssm.dao.PermissionDao;
import cn.itrock.ssm.po.Permission;
import cn.itrock.ssm.service.PermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;


    public PageInfo<Permission> findAllPermission(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);

        List<Permission> allPermission = permissionDao.findAllPermission();

        PageInfo<Permission> pageInfo = new PageInfo<>(allPermission);

        return pageInfo;
    }
//添加权限信息
    public void savePermission(Permission permission) {

        permissionDao.savePermission(permission);
    }

//删除权限信息
    public void delPermissionById(Long id) {
        permissionDao.delPermissionById(id);
    }
}
