package com.chanrin.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
//@EnableEurekaClient
@SpringBootApplication
public class ServiceProviderApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(ServiceProviderApplication.class);
    }
}
