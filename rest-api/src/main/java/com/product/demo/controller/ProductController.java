package com.product.demo.controller;


import com.product.demo.pojo.APIResponse;
import com.product.demo.pojo.CreateProductRequest;
import com.product.demo.model.Product;
import com.product.demo.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service){
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<APIResponse<Product>> createProduct(@RequestBody @Valid CreateProductRequest rq) {

        return new ResponseEntity<>(new APIResponse<>(service.createProduct(rq)), HttpStatus.OK);

    }

    @GetMapping("/{productId}/amount")
    public ResponseEntity<APIResponse<BigDecimal>> getProductAmount(@PathVariable String productId) {

        return new ResponseEntity<>(new APIResponse<>(service.getProductAmount(productId)), HttpStatus.OK);

    }
}
