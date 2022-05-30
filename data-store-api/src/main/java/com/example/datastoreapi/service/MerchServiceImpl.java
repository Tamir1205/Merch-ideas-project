package com.example.datastoreapi.service;

import com.example.datastoreapi.entity.CategoryEntity;
import com.example.datastoreapi.entity.CategoryRepository;
import com.example.datastoreapi.entity.MerchEntity;
import com.example.datastoreapi.entity.MerchRepository;
import com.example.datastoreapi.exception.ResourceNotFoundException;
import com.example.datastoreapi.model.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MerchServiceImpl implements MerchService {

    @Autowired
    MerchRepository merchRepository;

    @Autowired
    CategoryRepository categoryRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public MerchResponse createMerch(MerchRequest merchRequest) {
        merchRequest.setMerchId(UUID.randomUUID().toString());
        MerchEntity merchEntity = modelMapper.map(merchRequest, MerchEntity.class);
        merchEntity.setCategory(categoryRepository
                .findById(merchRequest.getCategory())
                .orElseThrow(() -> new ResourceNotFoundException("category "+merchRequest.getCategory() + " not found")));
        System.out.println(merchEntity.getCategory().toString());
        merchEntity = merchRepository.save(merchEntity);
        return modelMapper.map(merchEntity, MerchResponse.class);
    }



    @Override
    public MerchResponse getMerchById(String merchId) {
        return modelMapper.map(merchRepository.getMerchEntityByMerchId(merchId), MerchResponse.class);
    }

    @Override
    public List<MerchResponse> getAllMerch() {
        return merchRepository.getMerchEntitiesBy().stream()
                .map(merch -> modelMapper.map(merch, MerchResponse.class)).collect(Collectors.toList());
    }


    @Override
    public List<MerchResponse> getMerchByCategoryId(Long id) {
        return merchRepository.findAllByCategory(categoryRepository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("category "+ id + " not found")))
                .stream()
                        .map(merchEntity -> modelMapper
                                .map(merchEntity,MerchResponse.class))
                                .collect(Collectors.toList());
    }

    @Override
    public MerchResponse updateMerch(MerchRequest merchRequest) {
        MerchEntity merchEntity = modelMapper.map(merchRequest, MerchEntity.class);
        MerchEntity dbEntity = merchRepository.getMerchEntityByMerchId(merchEntity.getMerchId());
        merchEntity.setId(dbEntity.getId());
        merchEntity.setVotes(merchEntity.getVotes() + 1);
        merchEntity = merchRepository.save(merchEntity);
        return modelMapper.map(merchEntity, MerchResponse.class);
    }

    @Override
    public void deleteMerchById(String merchId) {
        merchRepository.deleteMerchEntityByMerchId(merchId);
    }

    @Override
    public MerchDTO sendMail(String merchId) {
        MerchDTO merchDTO=new MerchDTO();
        MerchResponse merchResponse=getMerchById(merchId);
        merchDTO.setMerchId(merchResponse.getMerchId());
        merchDTO.setBrandName(merchResponse.getBrandName());
        merchDTO.setOwnerId(merchResponse.getOwnerId());
        return merchDTO;
    }
}
