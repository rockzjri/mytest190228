package cn.itrock.ssm.service.impl;

import cn.itrock.ssm.dao.ProductDao;
import cn.itrock.ssm.po.Product;
import cn.itrock.ssm.service.ProductService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    //查询所有商品
    @Override
    public List<Product> findAllProducts() {
        return productDao.findAllProducts();
    }


    //添加商品
    @Override
    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

    //根据id修改用户列表
    public Product findProductById(Long id) {
        return productDao.findProductById(id);
    }
    //保存更新后列表
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    public void delProduct(Long id) {
        productDao.delProduct(id);
    }


    // 查询全部订单列表
    // * 改造接口方法：
    // *      1.将返回值类型改成PageHelper插件提供的PageInfo
    // *      2.增加参数当前页：pageNum，页面大小：pageSize
    public PageInfo<Product> findAllProducts(Integer pageNum, Integer pageSize) {


         PageHelper.startPage(pageNum, pageSize);

        List<Product> allProducts = productDao.findAllProducts();

        PageInfo<Product> productPageInfo = new PageInfo<>(allProducts);

        return productPageInfo;
    }
}
