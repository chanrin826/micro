package com.chanrin.micro.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        super.configure(http);   //为了访问控制台和actuetor时能安全控制
        http.csrf().ignoringAntMatchers("/eureka/**"); //忽略/eureka/*所有请求
    }
}
