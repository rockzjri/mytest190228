package cn.itrock.ssm.service;

import cn.itrock.ssm.po.Orders;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrdersService {
    //查询全部订单
    List<Orders> findAllOrders();

    //添加保存数据
    void saveOrder(Orders orders);

    //  根据id修改用户列表
    Orders findOrdersById(Long id);

    //修改订单数据
    void  updateOrders(Orders orders);

    //分页查询 查询全部订单列表
    // * 改造接口方法：
    // *      1.将返回值类型改成PageHelper插件提供的PageInfo
    // *      2.增加参数当前页：pageNum，页面大小：pageSize
    PageInfo<Orders> findAllOrders(Integer pageNum,Integer pageSize);

}
