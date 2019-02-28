package cn.itrock.ssm.dao;

import cn.itrock.ssm.po.SysLog;

import java.util.List;

public interface SysLogDao {
    //查询全部日志
    List<SysLog> findAllSysLogs();

    //添加新日志信息
    void saveSysLog(SysLog sysLog);
}
