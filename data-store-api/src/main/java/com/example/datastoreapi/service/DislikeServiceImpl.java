package com.example.datastoreapi.service;

import com.example.datastoreapi.entity.*;
import com.example.datastoreapi.model.DislikeRequest;
import com.example.datastoreapi.model.DislikeResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class DislikeServiceImpl implements DislikeService{

    @Autowired
    private MerchRepository merchRepository;

    @Autowired
    private DislikeRepository disLikeRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }
    @Override
    public DislikeResponse createDislike(DislikeRequest dislikeRequest) {
        dislikeRequest.setDislikeId(UUID.randomUUID().toString());

        DislikeEntity dislikeEntity = modelMapper.map(dislikeRequest, DislikeEntity.class);
        try {
            DislikeEntity dislikeEntity1 = disLikeRepository.getDislikeEntityByMerchIdAndUserId(dislikeEntity.getMerchId(),
                    dislikeEntity.getUserId());

            if (dislikeEntity1 == null) {
                dislikeEntity = disLikeRepository.save(dislikeEntity);

                MerchEntity dbEntity = merchRepository.getMerchEntityByMerchId(dislikeEntity.getMerchId());

                List<DislikeEntity> dislikes = disLikeRepository.getDislikeEntityByMerchId(dislikeEntity.getMerchId());
                int countVotes = dislikes.toArray().length;
                dbEntity.setVotes(countVotes);

                merchRepository.save(dbEntity);

                return modelMapper.map(dislikeEntity, DislikeResponse.class);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Error created with dislikes");
            return null;
        }
    }




    @Override
    public int getDislikesByMerchId(String merchId) {
        return disLikeRepository.getDislikeEntityByMerchId(merchId).size();
    }

    @Override
    public boolean getDislikeByMerchIdAndUserId(String merchId, String userId) {
        DislikeEntity dislikeEntity = disLikeRepository.getDislikeEntityByMerchIdAndUserId(merchId, userId);

        return dislikeEntity != null;
    }

    @Override
    public void deleteDislikeByMerchIdAndUserId(String merchId, String userId) {
        disLikeRepository.deleteDislikeEntityByMerchIdAndUserId(merchId, userId);

        MerchEntity dbEntity = merchRepository.getMerchEntityByMerchId(merchId);

        List<DislikeEntity> dislikes = disLikeRepository.getDislikeEntityByMerchId(merchId);
        int countVotes = dislikes.toArray().length;
        dbEntity.setVotes(countVotes);

        merchRepository.save(dbEntity);
    }
}
