package com.example.datastoreapi.controller;

import com.example.datastoreapi.model.MerchDTO;
import com.example.datastoreapi.model.MerchRequest;
import com.example.datastoreapi.model.MerchResponse;
import com.example.datastoreapi.service.MerchService;
import com.example.datastoreapi.service.message.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/merch")
public class MerchController {
    @Autowired
    MerchService merchService;
    @Autowired
    SendService sendService;

    @PostMapping
    MerchResponse createMerch(@RequestBody MerchRequest merchRequest) {
        return merchService.createMerch(merchRequest);
    }

    @GetMapping
    MerchResponse getMerchById(@RequestParam String merchId) {
        return merchService.getMerchById(merchId);
    }

    @GetMapping("/filter")
    List<MerchResponse> getMerchByCategory(@RequestParam(name = "categoryId") Long id) {
        return merchService.getMerchByCategoryId(id);
    }

    @GetMapping("/all")
    List<MerchResponse> getAllMerch() {
        return merchService.getAllMerch();
    }

    @PutMapping
    MerchResponse updateMerch(@RequestParam String merchId,
                              @RequestBody MerchRequest merchRequest) {
        merchRequest.setMerchId(merchId);
        return merchService.updateMerch(merchRequest);
    }

    @DeleteMapping
    String deleteMerch(@RequestParam String merchId) {
        merchService.deleteMerchById(merchId);
        return "merch successfully deleted";
    }

    @PostMapping("/mail")
    public MerchDTO sendEmail(@RequestParam String merchId) {
        MerchDTO merchDTO = merchService.sendMail(merchId);
        return  sendService.send(merchDTO);
    }
}
