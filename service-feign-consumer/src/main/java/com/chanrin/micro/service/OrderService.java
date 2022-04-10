package com.chanrin.micro.service;

import com.chanrin.micro.pojo.Orders;


public interface OrderService {

    Orders queryOrderByFeign(Integer id);

}
