package com.chanrin.micro.service.imp;

import com.chanrin.micro.pojo.Orders;
import com.chanrin.micro.pojo.Product;
import com.chanrin.micro.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Override
    public Orders queryOrderById(Integer id) {
        StringBuilder sb=null;

        //1、去注册中心获取服务列表
        List<String> serviceList = discoveryClient.getServices();
        if(serviceList==null){
            return  null;
        }
        serviceList.stream().forEach((item)->{
            System.out.println("服务:"+item);
        });
        //2、通过服务名称获取服务
        List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
        ServiceInstance serviceInstance = instances.get(0);
        sb=new StringBuilder();
        sb.append("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/api/productList");
        ResponseEntity<List> forEntity = restTemplate.getForEntity(sb.toString(), List.class);
        List<Product> body = (List<Product>) forEntity.getBody();
        System.out.println(body);
        Orders orders = new Orders(id,"121212","china",12121D,new ArrayList<>());
        orders.setProductList(body);
        return orders;
    }

    @Override
    public Orders queryOrderByLoadBanlacer(Integer id) {
        StringBuilder sb=null;

        //1、通过服务名称获取服务
        ServiceInstance choose = loadBalancerClient.choose("service-provider");
        if(choose==null){ return  null;}

        //2、通过服务名称获取服务

        sb=new StringBuilder();
        sb.append("http://"+choose.getHost()+":"+choose.getPort()+"/api/productList");

        System.out.println(sb.toString());
        ResponseEntity<List> forEntity = restTemplate.getForEntity(sb.toString(), List.class);
        List<Product> body = (List<Product>) forEntity.getBody();
        System.out.println(body);
        Orders orders = new Orders(id,"121212","china",12121D,new ArrayList<>());
        orders.setProductList(body);


        return orders;
    }

    @Override
    public Orders queryOrderByLoadBanlacerAnnotation(Integer id) {
        StringBuilder url=null;
        url=new StringBuilder();
//        1、首先在tempalate配置bean上面添加@LoadBalance

//        2、构造请求地址 地址为 http://服务名称/uri
        url.append("http://service-provider/api/productList");
        ResponseEntity<List> forEntity = restTemplate.getForEntity(url.toString(), List.class);
        List<Product> body = (List<Product>) forEntity.getBody();
        System.out.println(body);
        Orders orders = new Orders(id,"121212","china",12121D,new ArrayList<>());
        orders.setProductList(body);
        return orders;
    }
}
