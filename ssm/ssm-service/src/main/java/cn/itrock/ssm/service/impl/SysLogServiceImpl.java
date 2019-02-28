package cn.itrock.ssm.service.impl;

import cn.itrock.ssm.dao.SysLogDao;
import cn.itrock.ssm.po.SysLog;
import cn.itrock.ssm.service.SysLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogDao sysLogDao;


    public PageInfo<SysLog> findAllSysLogs(Integer pageNum, Integer pageSize) {
        //分页
        PageHelper.startPage(pageNum,pageSize);
        //查询分页数据
        List<SysLog> allSysLogs = sysLogDao.findAllSysLogs();
        //封装分页对象
        PageInfo<SysLog> sysLogPageInfo = new PageInfo<>(allSysLogs);
        return sysLogPageInfo;
    }

    public void saveSysLog(SysLog sysLog) {
        sysLogDao.saveSysLog(sysLog);
    }
}
