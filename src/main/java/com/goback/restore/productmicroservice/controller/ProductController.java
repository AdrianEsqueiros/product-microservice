package com.goback.restore.productmicroservice.controller;

import com.goback.restore.productmicroservice.entity.ProductEntity;
import com.goback.restore.productmicroservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    /*@GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProduct() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return new ResponseEntity<>(productEntities, HttpStatus.OK);
    }
    */

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createProduct(@RequestBody ProductEntity productEntity) {
        productRepository.save(productEntity);
    }
}
