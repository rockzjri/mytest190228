package cn.itrock.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

//<a href="${pageContext.request.contextPath}/common">去【普通页面】试试！</a><hr/>

    @RequestMapping("common")
    public String common(Model model) {
        model.addAttribute("title", "security欢迎你");
        model.addAttribute("message", "欢迎登陆common页面");
        return "common";
    }


    //        <a href="${pageContext.request.contextPath}/welcome">去【欢迎页面】试试！</a><hr/>
    @RequestMapping("welcome")
    public String welcome(Model model) {
        model.addAttribute("title", "security欢迎你");
        model.addAttribute("message", "欢迎登陆welcome页面");
        return "welcome";
    }

    //        <a href="${pageContext.request.contextPath}/admin">去【管理页面】试试！</a>
    @RequestMapping("admin")
    public String admin(Model model) {
        model.addAttribute("title", "security欢迎你");
        model.addAttribute("message", "欢迎登陆admin页面");
        return "admin";
    }
}
