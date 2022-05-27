package com.example.datastoreapi.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface LikeRepository extends CrudRepository<LikeEntity,Long> {
    List<LikeEntity> getAllBy();

    Boolean existsLikeModelByUserIdAndMerchId(String userId , String merchId);

    @Transactional
    void deleteLikeModelByUserIdAndMerchId(String userId , String merchId);

    long countByMerchId(String merchId);
}
