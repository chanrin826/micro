package com.chanrin.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * Hello world!
 *
 */
@EnableFeignClients
@SpringBootApplication
@EnableOpenApi
public class ServiceFeignConsumer
{
    public static void main( String[] args )
    {

        SpringApplication.run(ServiceFeignConsumer.class,args);

    }
}
