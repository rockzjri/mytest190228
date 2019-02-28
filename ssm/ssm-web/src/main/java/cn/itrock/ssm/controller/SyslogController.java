package cn.itrock.ssm.controller;

import cn.itrock.ssm.po.SysLog;
import cn.itrock.ssm.service.SysLogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sysLog")
public class SyslogController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("list/{pageNum}/{pageSize}")
  public String list(Model model, @PathVariable Integer pageNum, @PathVariable Integer pageSize){

        PageInfo<SysLog> sysLogs = sysLogService.findAllSysLogs(pageNum, pageSize);

        model.addAttribute("pageInfo",sysLogs);

        model.addAttribute("menuId","sysLog");

        return "syslog-list";

  }
}
