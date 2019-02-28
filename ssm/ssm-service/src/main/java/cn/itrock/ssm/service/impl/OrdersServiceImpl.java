package cn.itrock.ssm.service.impl;

import cn.itrock.ssm.dao.OrdersDao;
import cn.itrock.ssm.po.Orders;
import cn.itrock.ssm.service.OrdersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    //查询所有订单列表
    public List<Orders> findAllOrders() {
        return ordersDao.findAllOrders();
    }

    //保存订单列表
    public void saveOrder(Orders orders) {
        ordersDao.saveOrder(orders);
    }

    //根据id查找订单列表
    public Orders findOrdersById(Long id) {
        return ordersDao.findOrdersById(id);
    }



   public void  updateOrders(Orders orders){
        ordersDao.updateOrders(orders);
    }



    // 查询全部订单列表
    // * 改造接口方法：
    // *      1.将返回值类型改成PageHelper插件提供的PageInfo
    // *      2.增加参数当前页：pageNum，页面大小：pageSize
    public PageInfo<Orders> findAllOrders(Integer pageNum, Integer pageSize) {

        //设置分页
        PageHelper.startPage(pageNum,pageSize);
        //查询
        List<Orders> allOrders = ordersDao.findAllOrders();
        // 创建分页结果数据对象
        PageInfo<Orders> ordersPageInfo = new PageInfo<>(allOrders);

        return ordersPageInfo;
    }

}
