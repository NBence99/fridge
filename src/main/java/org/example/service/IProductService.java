package org.example.service;
import org.example.entity.ProductEntity;
import org.example.request.ProductRequest;

public interface IProductService {

    ProductEntity saveProduct(ProductRequest userRequest);

    ProductEntity getProductById(Long id);

    ProductEntity updateProduct(Long id, ProductRequest userRequest);

    void deleteProductById(Long id);

}
