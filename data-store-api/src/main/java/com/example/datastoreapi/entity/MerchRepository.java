package com.example.datastoreapi.entity;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface MerchRepository extends CrudRepository<MerchEntity, Long> {
    List<MerchEntity> getMerchEntitiesBy();

    MerchEntity getMerchEntityByMerchId(String merchId);
//    List<MerchEntity> getMerchEntitiesByCategory(Long category);
//    List<MerchEntity> getMerchEntitiesByBrandName(String brandName);

    List<MerchEntity> findAllByCategory(CategoryEntity entity);

    @Transactional
    void deleteMerchEntityByMerchId(String merchId);
}
