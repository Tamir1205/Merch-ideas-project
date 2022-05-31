package com.example.datastoreapi.controller;
import com.example.datastoreapi.entity.LikeEntity;
import com.example.datastoreapi.entity.LikeRepository;
import com.example.datastoreapi.model.LikeRequest;
import com.example.datastoreapi.model.LikeResponse;
import com.example.datastoreapi.service.LikeService;
import com.example.datastoreapi.service.LikeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/like")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @PostMapping
    public ResponseEntity<String> createLike(@RequestBody LikeRequest likeRequest) {
        LikeResponse likeResponse = likeService.createLike(likeRequest);
        if (likeResponse == null) {
            return new ResponseEntity<>("Dont liked", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
    }
    @GetMapping
    public boolean getLikeByMerchIdAndUserId(@RequestParam String merchId, @RequestParam String userId){
        return likeService.getLikeByMerchIdAndUserId(merchId, userId);
    }
    @GetMapping("/all")
    private int getLikesByMerchId(@RequestParam String merchId){
        return likeService.getLikesByMerchId(merchId);
    }


    @DeleteMapping
    public void deleteLikeByMerchIdAndUserId(@RequestParam String merchId, @RequestParam String userId){
        likeService.deleteLikeByMerchIdAndUserId(merchId, userId);
    }


}






//    @GetMapping("/all")
//    List<LikeEntity> getAll(){
//        return likeRepository.getAllBy();
//    }
//
//    @PostMapping("/{merchId}/{userId}")
//    void Like(@PathVariable String merchId, @PathVariable String userId){
//        Random random = new Random();
//        Long r = random.nextLong();
//        if(likeRepository.existsLikeModelByUserIdAndMerchId(userId,merchId)){
//            likeRepository.deleteLikeModelByUserIdAndMerchId(userId,merchId);
//        }
//        else{
//            likeRepository.save(
//                    new LikeEntity(
//                            r,
//                            merchId,
//                            userId
//                    )
//            );
//        }
//    }
//
//    @GetMapping("/{merchId}/{userId}")
//    boolean isLiked(@PathVariable String merchId, @PathVariable String userId){
//        return likeRepository.existsLikeModelByUserIdAndMerchId(userId,merchId);
//    }
//
//
//    @GetMapping("/{merchId}")
//    long countByMerchId(@PathVariable String merchId){
//        return likeRepository.countByMerchId(merchId);
//    }
//}
