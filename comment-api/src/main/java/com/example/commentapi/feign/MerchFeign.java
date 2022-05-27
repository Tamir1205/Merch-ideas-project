package com.example.commentapi.feign;

import com.example.commentapi.model.MerchModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("data-core-api")
public interface MerchFeign {
    @GetMapping("/merch")
    MerchModel getMerchById(@RequestParam String merchId);
}
