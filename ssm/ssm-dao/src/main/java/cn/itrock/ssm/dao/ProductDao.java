package cn.itrock.ssm.dao;

import cn.itrock.ssm.po.Product;

import java.util.List;


public interface ProductDao {

//    查询全部商品列表
    List<Product> findAllProducts();

//    添加商品
    void saveProduct(Product product);

//  根据id修改用户列表
    Product findProductById(Long id);

//    (修改后)更新保存数据
    void updateProduct(Product product);

//     根据id删除列表
    void delProduct(Long id);


}
