package com.ljp.ssm.product.service;

import com.ljp.ssm.product.model.Product;
import java.util.List;

public interface ProductService {
    // ���
    public void addProduct(Product product);

    //ɾ��
    public void deleteProduct(int productId);

    //�޸�
    public void updateProduct(Product product);

    // ͨ��id��ѯ
    public Product findProductById(int productId);

    //��ѯ����
    public List<Product> findAllProduct();
}
