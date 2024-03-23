package org.example.controller;
import org.example.entity.ProductEntity;
import org.example.request.ProductRequest;
import org.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping("/product")
    public ProductEntity saveProduct(@RequestBody ProductRequest request) {
        return productService.saveProduct(request);
    }

    @GetMapping("/product/{id}")
    public ProductEntity getProduct(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/product/{id}")
    public ProductEntity updateProduct(@PathVariable("id") Long id,@RequestBody ProductRequest request){
        return productService.updateProduct(id,request);
    }

    @DeleteMapping("/product/{id}")
    public void delProduct(@PathVariable("id") Long id){
        productService.deleteProductById(id);
    }
}

