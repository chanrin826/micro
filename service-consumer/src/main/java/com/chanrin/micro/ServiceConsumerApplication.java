package com.chanrin.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
//@EnableEurekaClient
@SpringBootApplication
public class ServiceConsumerApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(ServiceConsumerApplication.class);
    }
}
