package com.chanrin.micro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders implements Serializable {

    private Integer id;

    private String orderNo;

    private  String orderAddress;

    private  Double totalPrice;

    private List<Product> productList;
}