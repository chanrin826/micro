package com.chanrin.micro.controller;

import com.chanrin.micro.pojo.Product;
import com.chanrin.micro.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("productList")
    public List<Product> queryList(){
        List<Product> products = productService.queryProductList();
        return products;
    }
}
