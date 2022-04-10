package com.chanrin.micro.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Target;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Slf4j
@Component
public class MyFeignIntercepter implements RequestInterceptor {
    private static final String HOST="http://127.0.0.1:7070";


    @Override
    public void apply(RequestTemplate template) {
        RequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        if (Objects.nonNull(requestAttributes)) {
            ServletRequestAttributes httpRequest = (ServletRequestAttributes) requestAttributes;
            HttpServletRequest request = httpRequest.getRequest();
            template.header("yao",request.getHeader("yao"));
            log.info("拦截收到header头内容：{}",request.getHeader("yao"));
        }
//        log.info("feign实体{}", JSON.toJSONString(template));
        Target<?> target = template.feignTarget();
        Target.HardCodedTarget hardCodedTarget = new Target.HardCodedTarget(target.type(), target.name(), HOST);
        template.feignTarget(hardCodedTarget);
        template.target(HOST);
//        log.info("feign实体{}", JSON.toJSONString(template));
    }
}
