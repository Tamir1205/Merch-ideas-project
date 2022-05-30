package com.example.datastoreapi.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DislikeRepository extends CrudRepository<DislikeEntity,Long> {
    List<DislikeEntity> getDislikeEntityByMerchId(String merchId);

    DislikeEntity getDislikeEntityByMerchIdAndUserId(String merchId, String userId);

    @Transactional
    void deleteDislikeEntityByMerchIdAndUserId(String merchId, String userId);


}
