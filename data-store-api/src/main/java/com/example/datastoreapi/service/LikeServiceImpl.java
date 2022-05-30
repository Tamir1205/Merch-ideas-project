package com.example.datastoreapi.service;

import com.example.datastoreapi.entity.LikeEntity;
import com.example.datastoreapi.entity.LikeRepository;
import com.example.datastoreapi.entity.MerchEntity;
import com.example.datastoreapi.entity.MerchRepository;
import com.example.datastoreapi.model.LikeRequest;
import com.example.datastoreapi.model.LikeResponse;
import com.example.datastoreapi.model.MerchRequest;
import com.example.datastoreapi.model.MerchResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    private MerchRepository merchRepository;

    @Autowired
    private LikeRepository likeRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }


    @Override
    public LikeResponse createLike(LikeRequest likeRequest) {
        likeRequest.setLikeId(UUID.randomUUID().toString());
        LikeEntity likeEntity = modelMapper.map(likeRequest, LikeEntity.class);
        try {
            LikeEntity likeEntity1 = likeRepository.getLikeEntityByMerchIdAndUserId(likeEntity.getMerchId(),
                    likeEntity.getUserId());

            if (likeEntity1 == null) {
                likeEntity = likeRepository.save(likeEntity);

                MerchEntity dbEntity = merchRepository.getMerchEntityByMerchId(likeEntity.getMerchId());

                List<LikeEntity> likes = likeRepository.getLikeEntityByMerchId(likeEntity.getMerchId());
                int countVotes = likes.toArray().length;
                dbEntity.setVotes(countVotes);

                merchRepository.save(dbEntity);

                return modelMapper.map(likeEntity, LikeResponse.class);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Don`t created like");
            return null;
        }
    }



    @Override
    public boolean getLikeByMerchIdAndUserId(String merchId, String userId) {
        LikeEntity likeEntity = likeRepository.getLikeEntityByMerchIdAndUserId(merchId, userId);

        return likeEntity != null;
    }

    @Override
    public void deleteLikeByMerchIdAndUserId(String merchId, String userId) {

        likeRepository.deleteLikeEntityByMerchIdAndUserId(merchId, userId);

        MerchEntity dbEntity = merchRepository.getMerchEntityByMerchId(merchId);

        List<LikeEntity> likes = likeRepository.getLikeEntityByMerchId(merchId);
        int countVotes = likes.toArray().length;
        dbEntity.setVotes(countVotes);

        merchRepository.save(dbEntity);
    }
    @Override
    public int getLikesByMerchId(String merchId) {
        return likeRepository.getLikeEntityByMerchId(merchId).size();
    }
}
