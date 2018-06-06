package com.soecode.lyf.service.impl;


import com.soecode.lyf.IDao.ProductDao;
import com.soecode.lyf.IDao.ResourceDao;
import com.soecode.lyf.entity.Product;
import com.soecode.lyf.entity.Resource;
import com.soecode.lyf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/5/22.
 *
 * @author ZLC
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;
    @Override
    public int insertProduct(Product p) {
        return productDao.insert(p);
    }

    @Override
    public List<Product> selectAll() {
        return productDao.selectAll();
    }

    @Override
    public Product selectByPK(Integer productId) {
        return productDao.selectByPrimaryKey(productId);
    }

    @Override
    public int deleteByPK(Integer supply_id) {
        return productDao.deleteByPrimaryKey(supply_id);
    }

    @Override
    public int update(Product product) {
        return productDao.updateByPrimaryKeySelective(product);
    }


}
