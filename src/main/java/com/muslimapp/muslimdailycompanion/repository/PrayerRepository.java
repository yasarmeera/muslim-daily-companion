package com.muslimapp.muslimdailycompanion.repository;

import com.muslimapp.muslimdailycompanion.entity.Prayer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PrayerRepository extends JpaRepository<Prayer, Long> {
    List<Prayer> findByUserId(Long userId);
}