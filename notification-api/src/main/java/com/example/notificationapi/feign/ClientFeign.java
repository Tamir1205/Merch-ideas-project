package com.example.notificationapi.feign;

import com.example.notificationapi.model.ClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "main-api")
public interface ClientFeign {
    @GetMapping(value="/main-api/client",consumes= MediaType.APPLICATION_JSON_VALUE)
    ClientDTO getClientById(@RequestParam String clientId);
}
