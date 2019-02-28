package cn.itrock.ssm.service.impl;

import cn.itrock.ssm.dao.RoleDao;
import cn.itrock.ssm.po.Permission;
import cn.itrock.ssm.po.Role;
import cn.itrock.ssm.service.RolesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RoleDao roleDao;

    //-----查询role-list---------------------------------------------------------------
    public PageInfo<Role> findAllRoles(Integer pageNum, Integer pageSize) {

        //查询分页
        PageHelper.startPage(pageNum, pageSize);
        //查询数据
        List<Role> allRoles = roleDao.findAllRoles();
        //封装分页对象
        PageInfo<Role> rolePageInfo = new PageInfo<>(allRoles);

        return rolePageInfo;
    }

    //------添加新role--------------------------------------------------------------------
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    //------权限分配-----------------------------------------------------------------------
    public Role findRoleAndPermissionsById(Long roleId) {
        return roleDao.findRoleAndPermissionsById(roleId);
    }


    public List<Permission> findAllPermissions() {
        return roleDao.findAllPermissions();
    }

    public void addRoleAndPermission(Long roleId, Long[] RoleIdAndPermissionId) {

        roleDao.delRoleAndPermission(roleId);

        for (int a = 0; a < RoleIdAndPermissionId.length; a++) {
            Long[] tem = {roleId, RoleIdAndPermissionId[a]};
            roleDao.addRoleAndPermission(tem);
        }
    }

}
