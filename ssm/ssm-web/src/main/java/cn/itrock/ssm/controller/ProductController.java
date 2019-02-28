package cn.itrock.ssm.controller;

import cn.itrock.ssm.po.Product;
import cn.itrock.ssm.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    //注入商品
    @Autowired
    private ProductService productService;

    /**
     * 查询全部订单列表
     * 改造查询订单列表方法：
     *      1.请求的url格式，增加请求的当前页和页面大小参数：list/1/5
     *      2.使用PathVariable注解，绑定模版参数值，到方法形参上
     *      3.将响应的模型数据名称统一为：pageInfo
     */

    //查询所有商品列表
    @RequestMapping("list/{pageNum}/{pageSize}")
    public String list(Model model,@PathVariable Integer pageNum,@PathVariable Integer pageSize){

//        List<Product> productList = productService.findAllProducts();

        PageInfo<Product> allProducts = productService.findAllProducts(pageNum, pageSize);


        model.addAttribute("pageInfo",allProducts);
        model.addAttribute("menuId","product");
        return "product-list";
    }

    //跳转到添加商品页面
    @RequestMapping("add")
    public String add(){
        return "product-add";
    }

    //添加商品
    @RequestMapping("save")
    public String save(Product product){
        productService.saveProduct(product);

        return "redirect:/product/list/1/5";
    }

    //根据用户id修改用户列表
    @RequestMapping("edit/{id}")
    public String update(Model model, @PathVariable("id") Long id){
        Product productById = productService.findProductById(id);
        model.addAttribute("product",productById);

        return "product-update";

    }

    //保存更新（修改后）列表
    @RequestMapping("update")
    public String update(Product product){
        productService.updateProduct(product);

        return "redirect:/product/list/1/5";
    }

    //根据用户id展示用户列表
    @RequestMapping("show/{id}")
    public String show(Model model, @PathVariable("id") Long id){
        Product productById = productService.findProductById(id);
        model.addAttribute("product",productById);

        return "product-update";
    }

    //根据id删除
    @RequestMapping("del/{id}")
    public String del(@PathVariable("id") Long id){
        productService.delProduct(id);
        return "redirect:/product/list/1/5";
    }

}
