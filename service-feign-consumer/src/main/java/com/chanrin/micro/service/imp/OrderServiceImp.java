package com.chanrin.micro.service.imp;

import com.chanrin.micro.feign.ProductFeignService;
import com.chanrin.micro.pojo.Orders;
import com.chanrin.micro.pojo.Product;
import com.chanrin.micro.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImp implements OrderService {

    @Resource
    private ProductFeignService productFeignService;

    @Override
    public Orders queryOrderByFeign(Integer id) {
        List<Product> products = productFeignService.queryList();
        Orders orders = Orders.builder()
                .id(id)
                .productList(products)
                .orderAddress("重庆市垫江县")
                .orderNo("705713")
                .totalPrice(300.00).build();
        return orders;
    }




}
