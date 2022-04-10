package com.chanrin.micro.service;

import com.chanrin.micro.pojo.Orders;


public interface OrderService {

    Orders queryOrderById(Integer id);

    Orders queryOrderByLoadBanlacer(Integer id);


    Orders queryOrderByLoadBanlacerAnnotation(Integer id);

}
