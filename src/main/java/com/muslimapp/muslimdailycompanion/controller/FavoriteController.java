package com.muslimapp.muslimdailycompanion.controller;

import com.muslimapp.muslimdailycompanion.entity.Favorite;
import com.muslimapp.muslimdailycompanion.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @PostMapping
    public Favorite saveFavorite(@RequestBody Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    @GetMapping("/user/{userId}")
    public List<Favorite> getFavoritesByUser(@PathVariable Long userId) {
        return favoriteRepository.findByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteFavorite(@PathVariable Long id) {
        favoriteRepository.deleteById(id);
    }
}