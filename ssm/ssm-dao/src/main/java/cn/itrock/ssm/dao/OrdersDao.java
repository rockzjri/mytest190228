package cn.itrock.ssm.dao;

import cn.itrock.ssm.po.Orders;

import java.util.List;

public interface OrdersDao {
    //查询全部订单
    List<Orders> findAllOrders();

    //添加保存数据
    void saveOrder(Orders orders);

    //  根据id修改用户列表
    Orders findOrdersById(Long id);

    //修改订单数据
    void updateOrders(Orders orders);

}
