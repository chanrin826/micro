package com.chanrin.micro.interpretor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FegnRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("test-header", "chanrin");
    }
}
