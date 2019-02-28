package cn.itrock.ssm.controller;

import cn.itrock.ssm.dao.RoleDao;
import cn.itrock.ssm.po.Permission;
import cn.itrock.ssm.po.Role;
import cn.itrock.ssm.service.RolesService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RolesService rolesService;

    @Autowired
    private RoleDao roleDao;

    //------查询所有role-------------------------------------------------------------------------
    //<a href="${pageContext.request.contextPath}/role/list/1/5">角色管理</a>
    @RequestMapping("list/{pageNum}/{pageSize}")
    public String list(Model model, @PathVariable Integer pageNum,@PathVariable Integer pageSize){

        PageInfo<Role> allRoles = rolesService.findAllRoles(pageNum, pageSize);

        model.addAttribute("pageInfo",allRoles);

        //响应页面
        model.addAttribute("menuId","role");

        return "role-list";
    }

    //--------添加新role----------------------------------------------------------------------------------
    @RequestMapping("add")
    public String add(){
        return "role-add";
    }
    @RequestMapping("save")
    public String save(Role role){
        rolesService.saveRole(role);
        return "redirect:/role/list/1/5";
    }
    //----分配权限-------------------------------------------------------------------------------------------



    //http://localhost:8080/data-management/role/permissionAdd/2
    @RequestMapping("permissionAdd/{id}")
    public String findRoleAndPermissionsById(Model model,@PathVariable("id") Long id){

        Role roleAndPermissionsById = rolesService.findRoleAndPermissionsById(id);

        List<Permission> allPermissions = rolesService.findAllPermissions();

        // 设置已经有的权限为选中
        List<Permission> permissionList = roleAndPermissionsById.getPermissionList();
        for (Permission allPermission : allPermissions) {
            for (Permission permission : permissionList) {
                if (allPermission.getId()==permission.getId()){
                       allPermission.setChecked(1);
                       break;
                }
            }
        }

        model.addAttribute("permissionList",allPermissions);
        model.addAttribute("role",roleAndPermissionsById);

        return "role-permission-add";
    }
    //action="${pageContext.request.contextPath}/role/addPermissionToRole"
    @RequestMapping("addPermissionToRole")
    public String addRoleAndPermission(Long roleId,Long[] ids){

        if (ids!=null&&ids.length>0){
            rolesService.addRoleAndPermission(roleId,ids);
        }
        return "redirect:/role/list/1/5";
    }
}
