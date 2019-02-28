package cn.itrock.ssm.controller;

import cn.itrock.ssm.po.Permission;
import cn.itrock.ssm.service.PermissionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    //查询全部list-----------------------------------------------------------------------
    //http://localhost:8080/data-management/permission/list/1/5
    @RequestMapping("list/{pageNum}/{pageSize}")
    public String list(Model model, @PathVariable Integer pageNum,@PathVariable Integer pageSize){

        PageInfo<Permission> allPermission = permissionService.findAllPermission(pageNum, pageSize);

        model.addAttribute("pageInfo",allPermission);
        model.addAttribute("menuId","permission");

        return "permission-list";
    }

    //---添加新权限permission---------------------------------------------------------------------
    @RequestMapping("add")
    public String add(){
        return "permission-add";
    }
    @RequestMapping("save")
    public String save(Permission permission){
        permissionService.savePermission(permission);
        return "redirect:/permission/list/1/5";
    }
    //-----删除权限信息-------------------------------------------------------------------------------------
@RequestMapping("del/{id}")
    public String del(@PathVariable("id") Long id){

        permissionService.delPermissionById(id);
        return "redirect:/permission/list/1/5";
}


}
