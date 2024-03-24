package org.example.service.impl;

import lombok.SneakyThrows;
import org.example.entity.ProductEntity;
import org.example.exception.ProductNotFoundException;
import org.example.repository.IProductRepository;
import org.example.request.ProductRequest;
import org.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public ProductEntity saveProduct(ProductRequest userRequest) {
        ProductEntity productEntity = ProductEntity.builder()
                .name(userRequest.getName())
                .piece(userRequest.getPiece())
                .expirationDate(userRequest.getExpirationDate())
                .build();
        return productRepository.save(productEntity);
    }

    @Override
    @SneakyThrows
    public ProductEntity getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    @SneakyThrows
    public ProductEntity updateProduct(Long id, ProductRequest productRequest) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        productEntity.setName(productRequest.getName());
        productEntity.setPiece(productRequest.getPiece());
        return productRepository.save(productEntity);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);

    }
}
