package cn.itrock.ssm.service;

import cn.itrock.ssm.po.Product;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductService {

    //查询所有商品列表
    List<Product> findAllProducts();

    //    添加商品
    void saveProduct(Product product);

    //    根据用户Id查询商品列表
    Product findProductById(Long id);

    //    (修改后)更新保存数据
    void updateProduct(Product product);

    //     根据id删除列表
    void delProduct(Long id);

    // 查询全部订单列表
    // * 改造接口方法：
    // *      1.将返回值类型改成PageHelper插件提供的PageInfo
    // *      2.增加参数当前页：pageNum，页面大小：pageSize
    PageInfo<Product> findAllProducts(Integer pageNum,Integer pageSize);
}
