package com.chanrin.micro.feign;

import com.chanrin.micro.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(name = "SERVICE-PROVIDER22",
url = "111")
public interface ProductFeignService {

    @GetMapping("/api/productList")
  public List<Product> queryList();

    @PostMapping(value = "/api/file",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Boolean filetest(MultipartFile file, @RequestParam("name") String name);
}
