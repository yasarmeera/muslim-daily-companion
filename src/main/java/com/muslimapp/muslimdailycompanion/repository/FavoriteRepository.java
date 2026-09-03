package com.muslimapp.muslimdailycompanion.repository;

import com.muslimapp.muslimdailycompanion.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByUserId(Long userId);
}