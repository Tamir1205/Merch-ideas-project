package com.example.datastoreapi.controller;

import com.example.datastoreapi.entity.LikeEntity;
import com.example.datastoreapi.entity.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/merch")
public class LikeController {
    @Autowired
    LikeRepository likeRepository;

    @GetMapping("/all")
    List<LikeEntity> getAll(){
        return likeRepository.getAllBy();
    }

    @PostMapping("/{merchId}/{userId}")
    void Like(@PathVariable String merchId, @PathVariable String userId){
        Random random = new Random();
        Long r = random.nextLong();
        if(likeRepository.existsLikeModelByUserIdAndMerchId(userId,merchId)){
            likeRepository.deleteLikeModelByUserIdAndMerchId(userId,merchId);
        }
        else{
            likeRepository.save(
                    new LikeEntity(
                            r,
                            merchId,
                            userId
                    )
            );
        }
    }

    @GetMapping("/{merchId}/{userId}")
    boolean isLiked(@PathVariable String merchId, @PathVariable String userId){
        return likeRepository.existsLikeModelByUserIdAndMerchId(userId,merchId);
    }



    @GetMapping("/{merchId}")
    long countByMerchId(@PathVariable String merchId){
        return likeRepository.countByMerchId(merchId);
    }
}
