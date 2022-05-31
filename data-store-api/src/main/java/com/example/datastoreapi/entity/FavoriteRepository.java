package com.example.datastoreapi.entity;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface FavoriteRepository extends CrudRepository<FavoriteEntity,Long> {
    FavoriteEntity getFavoriteEntityByUserIdAndMerchId(String userId, String  merchId);

    List<FavoriteEntity> getFavoriteEntitiesBy();

    List<FavoriteEntity> getFavoriteEntitiesByUserId(String userId);

    @Transactional
    void deleteFavoriteEntitiesByFavoriteId(String favoriteId);
}
