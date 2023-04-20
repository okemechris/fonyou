package com.product.demo.service;


import com.product.demo.pojo.CreateProductRequest;
import com.product.demo.exception.NotFoundException;
import com.product.demo.model.Product;
import com.product.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository productRepository){
        repository = productRepository;
    }


    public Product createProduct(CreateProductRequest rq){

        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setAmount(rq.getAmount());
        product.setDescription(rq.getDescription());
        product.setActive(rq.isActive());

        return repository.save(product);
    }

    public BigDecimal getProductAmount(String id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("product with specified id not found")).getAmount();
    }
}
