package cn.itrock.ssm.service;

import cn.itrock.ssm.po.SysLog;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SysLogService {

    //查询全部日志
    PageInfo<SysLog> findAllSysLogs(Integer pageNum,Integer pageSize);

    //添加新日志信息
    void saveSysLog(SysLog sysLog);
}
