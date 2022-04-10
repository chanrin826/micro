package com.chanrin.micro.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


//默认状态下 restTemplate没有开启 需要手动开启
@Configuration
public class RestTemplateConfig {

    @LoadBalanced    //不能和LoadBalancerClinet同时使用  会冲突  二选其一
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
