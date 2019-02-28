package cn.itrock.ssm.controller;

import cn.itrock.ssm.dao.ProductDao;
import cn.itrock.ssm.po.Orders;
import cn.itrock.ssm.po.Product;
import cn.itrock.ssm.service.OrdersService;
import cn.itrock.ssm.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("order")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ProductService productService;



    /**
     * 查询全部订单列表
     * 改造查询订单列表方法：
     *      1.请求的url格式，增加请求的当前页和页面大小参数：list/1/5
     *      2.使用PathVariable注解，绑定模版参数值，到方法形参上
     *      3.将响应的模型数据名称统一为：pageInfo
     */
    @RequestMapping("list/{pageNum}/{pageSize}")
    public String list(Model model,@PathVariable Integer pageNum,@PathVariable Integer pageSize){

//        List<Orders> list = ordersService.findAllOrders();

        PageInfo<Orders> allOrders = ordersService.findAllOrders(pageNum, pageSize);

        model.addAttribute("pageInfo" ,allOrders);

        model.addAttribute("menuId","order");

        return "order-list";
    }

    //添加新数据订单
    @RequestMapping("add")
    public String add(Model model){

        List<Product> products = productService.findAllProducts();
        model.addAttribute("plist",products);


        return "order-add";
    }

    //保存数据信息
    @RequestMapping("save")
    public String save(Orders orders){

        ordersService.saveOrder(orders);

        return "redirect:/order/list/1/5";
    }

    //修改订单信息
    @RequestMapping("edit/{id}")
    public String edit(Model model,@PathVariable("id") Long id){

        Orders ordersById = ordersService.findOrdersById(id);

        model.addAttribute("orders",ordersById);

        return "order-update";
    }

    @RequestMapping("update")
    public String update(Orders orders){

       ordersService.updateOrders(orders);

    return "redirect:/order/list/1/5";
    }

}

