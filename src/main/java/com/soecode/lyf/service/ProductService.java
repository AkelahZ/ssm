package com.soecode.lyf.service;

import com.soecode.lyf.entity.Product;

import java.util.List;

/**
 * Created by Administrator on 2018/5/22.
 *
 * @author ZLC
 */
public interface ProductService {
    int insertProduct(Product p);
    List<Product> selectAll();
    Product selectByPK(Integer productId);

    int deleteByPK(Integer productId);

    int update(Product product);
}
