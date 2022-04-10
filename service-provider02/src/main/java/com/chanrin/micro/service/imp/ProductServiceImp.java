package com.chanrin.micro.service.imp;

import com.chanrin.micro.pojo.Product;
import com.chanrin.micro.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Override
    public List<Product> queryProductList() {
        List<Product> list = Arrays.asList(
                new Product(1, "华为手机7071", 2, 4999D),
                new Product(1, "小米7071", 4, 3999D),
                new Product(1, "vivo7071", 7, 2999D)
        );
        return list;
    }
}
