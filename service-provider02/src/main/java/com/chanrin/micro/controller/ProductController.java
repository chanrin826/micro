package com.chanrin.micro.controller;

import com.chanrin.micro.pojo.Product;
import com.chanrin.micro.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("productList")
    public List<Product> queryList(@RequestHeader("yao") String yao){
        log.info("接收到header参数：{}",yao);
        List<Product> products = productService.queryProductList();
        return products;
    }

    @PostMapping("file")
    public Boolean filetest(MultipartFile file,String name){
        if (file==null) {
            return false;
        }
        return true;
    }
}
