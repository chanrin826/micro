package com.chanrin.micro.controller;

import com.chanrin.micro.config.MyHolder;
import com.chanrin.micro.feign.ProductFeignService;
import com.chanrin.micro.pojo.Orders;
import com.chanrin.micro.service.OrderService;
import com.chanrin.micro.utils.BASE64DecodedMultipartFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Api(tags = "订单接口")
@RestController
@RequestMapping("/api")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @Resource
    private ProductFeignService productFeignService;

    @Autowired
    private RestTemplate restTemplate;


    @ApiOperation(value = "feign接口-id获取订单信息",response =Orders.class)
    @GetMapping("order/feign/{id}")
    public Orders balanceAnnotation(@PathVariable Integer id){
        MyHolder.setName("yaoyi");
        Orders orders = orderService.queryOrderByFeign(id);
        return orders;
    }

    @PostMapping("order/feign/file")
    public Boolean file(@RequestBody BaseHa base){
        MultipartFile multipartFile = BASE64DecodedMultipartFile.base64ToMultipart(base.getBase());
        Boolean test1 = productFeignService.filetest(multipartFile, "test1");
        return test1;
    }

    @PostMapping("order/feign/file3")
    public Boolean file3(@RequestBody BaseHa base){
//        MultipartFile multipartFile = BASE64DecodedMultipartFile.base64ToMultipart(base.getBase());
//        String url="http://localhost:7071/api/file";
//        restTemplate.postForEntity(url,);
//        Boolean test1 = productFeignService.filetest(multipartFile, "test1");
//
//
//        //设置请求头(注意会产生中文乱码)
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(
//                popHeaders(obj), headers);
//        //发送请求，设置请求返回数据格式为String
//        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http:xxx.xx", request, String.class);
//        return test1;
        return null;
    }


    @PostMapping("order/feign/file2")
    public Boolean file2(MultipartFile file){
        Boolean test1 = productFeignService.filetest(file, "test2");
        return test1;
    }

//    protected MultiValueMap<String, String> popHeaders(Object obj) {
//        SubmitOrderDTO submit = (SubmitOrderDTO) obj;
//        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
//
//        map.add("order_id", submit.getOrderId());
//        map.add("userName",submit.getUserName());
//        //.....
//        return map;
//    }


}

@Data
class BaseHa{
   private String base;
}
