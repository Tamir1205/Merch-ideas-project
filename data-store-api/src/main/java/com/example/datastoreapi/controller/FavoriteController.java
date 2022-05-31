package com.example.datastoreapi.controller;

import com.example.datastoreapi.model.FavoriteRequest;
import com.example.datastoreapi.model.FavoriteResponse;
import com.example.datastoreapi.service.FavoriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class FavoriteController {
    @Autowired
    private FavoriteServiceImpl favoriteService;

    @PostMapping
    public ResponseEntity<String> createFavorite(@RequestBody FavoriteRequest favoriteRequest) {
        FavoriteResponse favoriteResponse = favoriteService.createFavorite(favoriteRequest);
        if (favoriteResponse == null) {
            return new ResponseEntity<>("Dont added", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
    }

    @GetMapping("/all")
    public List<FavoriteResponse> getAllFavorites() {
        return favoriteService.getAllFavorites();
    }

    @GetMapping
    public List<FavoriteResponse> getFavoritesByUserId(@RequestParam String userId) {
        return favoriteService.getFavoritesByUserId(userId);
    }

    @DeleteMapping
    public void deleteFavorite(@RequestParam String favoriteId) {
        favoriteService.deleteFavoriteByFavoriteId(favoriteId);
    }
}
