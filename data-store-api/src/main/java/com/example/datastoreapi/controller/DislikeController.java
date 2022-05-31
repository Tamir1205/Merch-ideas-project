package com.example.datastoreapi.controller;

import com.example.datastoreapi.model.DislikeRequest;
import com.example.datastoreapi.model.DislikeResponse;
import com.example.datastoreapi.service.DislikeService;
import com.example.datastoreapi.service.DislikeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dislike")

public class DislikeController {
    @Autowired
    private DislikeService dislikeService;

    @PostMapping
    public ResponseEntity<String> createLike(@RequestBody DislikeRequest dislikeRequest) {
        DislikeResponse dislikeResponse = dislikeService.createDislike(dislikeRequest);
        if (dislikeResponse == null) {
            return new ResponseEntity<>("Dont disliked", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
    }
    @GetMapping("/all")
    private int getDislikesByMerchId(@RequestParam String merchId){
        return dislikeService.getDislikesByMerchId(merchId);
    }
    @GetMapping
    public boolean getDislikeByMerchIdAndUserId(@RequestParam String merchId, @RequestParam String userId){
        return dislikeService.getDislikeByMerchIdAndUserId(merchId, userId);
    }

    @DeleteMapping
    public void deleteDislikeByMerchIdAndUserId(@RequestParam String merchId, @RequestParam String userId){
        dislikeService.deleteDislikeByMerchIdAndUserId(merchId, userId);
    }

}
