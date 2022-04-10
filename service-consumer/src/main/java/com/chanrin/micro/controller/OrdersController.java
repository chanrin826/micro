package com.chanrin.micro.controller;

import com.chanrin.micro.pojo.Orders;
import com.chanrin.micro.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @GetMapping("order")
    public Orders queryList(){
        Orders orders = orderService.queryOrderById(12);
        return orders;
    }

    @GetMapping("order/{id}")
    public Orders queryListByBalancer(@PathVariable Integer id){
        Orders orders = orderService.queryOrderByLoadBanlacer(id);
        return orders;
    }

    @GetMapping("order/balance/{id}")
    public Orders balanceAnnotation(@PathVariable Integer id){
        Orders orders = orderService.queryOrderByLoadBanlacerAnnotation(id);
        return orders;
    }
}
