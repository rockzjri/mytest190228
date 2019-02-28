package cn.itrock.ssm.controller;

import cn.itrock.ssm.po.Role;
import cn.itrock.ssm.po.User;
import cn.itrock.ssm.service.UserService;

import cn.itrock.ssm.util.MD5Util;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    //-------------------------------------------------------------
    //查询所有user信息
    @RequestMapping("list/{pageNum}/{pageSize}")
    public String list(Model model, @PathVariable Integer pageNum, @PathVariable Integer pageSize) {

        //查询所有数据用户list
        PageInfo<User> allUsers = userService.findAllUsers(pageNum, pageSize);
        model.addAttribute("pageInfo", allUsers);

        //相应当前页面
        model.addAttribute("menuId", "user");

        return "user-list";
    }

    //----------------------添加新----------------------------------------
    //添加新user
    @RequestMapping("add")
    public String add() {
        return "user-add";
    }

    //新user保存
    @RequestMapping("save")
    public String save(User user) {



        user.setPassword(MD5Util.md5(user.getPassword()));

        userService.saveUser(user);
        return "redirect:/user/list/1/5";
    }
//-------------------根据id的查询用户-------------------------------------------

    @RequestMapping("show/{id}")
    public String show(Model model, @PathVariable("id") Long id) {
        User userById = userService.findUserById(id);
        model.addAttribute("user", userById);
        return "user-show";
    }


    //-------------------查询role--------------------------
//http://localhost:8080/data-management/user/roleAdd/1
    @RequestMapping("/roleAdd/{id}")
    public String roleAdd(Model model, @PathVariable("id") Long id) {

        User userById = userService.findUserById(id);

        model.addAttribute("user", userById);

        List<Role> allRoles = userService.findAllRoles();

//        List<Role> roleList = userById.getRoleList();
//        for (Role allRole : allRoles) {
//            for (Role role : roleList) {
//                if (allRole.getId() == role.getId()) {
//                    allRole.setChecked(1);
//                    break;
//                }
//            }
//
//        }


        model.addAttribute("roleList", allRoles);

        return "user-role-add";
    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(Long userId, Long[] ids) {

        if (ids != null && ids.length > 0) {
            userService.addUserToRole(userId, ids);
        }
        return "redirect:/user/list/1/5";

    }

}
