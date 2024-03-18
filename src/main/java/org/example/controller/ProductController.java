package org.example.controller;
import org.example.entity.ProductEntity;
import org.example.request.ProductRequest;
import org.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private IProductService IProductService;

    @PostMapping("/product")
    public ProductEntity saveUser(@RequestBody ProductRequest request) {
        return IProductService.saveProduct(request);
    }

    @GetMapping("/product/{id}")
    public ProductEntity getUser(@PathVariable("id") Long id) {
        return IProductService.getProductById(id);
    }
}

