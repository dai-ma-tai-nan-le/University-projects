package com.ljp.ssm.product.service.impl;

import com.ljp.ssm.product.dao.ProductMapper;
import com.ljp.ssm.product.model.Product;
import com.ljp.ssm.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public void addProduct(Product product) {
        productMapper.addProduct(product);
    }

    @Override
    public void deleteProduct(int productId) {
        productMapper.deleteProduct(productId);
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    @Override
    public Product findProductById(int productId) {
        return productMapper.findProductById(productId);
    }

    @Override
    public List<Product> findAllProduct() {
        return productMapper.findAllProduct();
    }
}
