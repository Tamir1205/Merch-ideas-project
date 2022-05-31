package com.example.datastoreapi.service;

import com.example.datastoreapi.model.FavoriteRequest;
import com.example.datastoreapi.model.FavoriteResponse;

import java.util.List;

public interface FavoriteSevice {
    FavoriteResponse createFavorite(FavoriteRequest favoriteRequest);

    List<FavoriteResponse> getAllFavorites();

    List<FavoriteResponse> getFavoritesByUserId(String userId);

    void deleteFavoriteByFavoriteId(String favoriteId);
}
