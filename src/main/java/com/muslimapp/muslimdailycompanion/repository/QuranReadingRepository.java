package com.muslimapp.muslimdailycompanion.repository;

import com.muslimapp.muslimdailycompanion.entity.QuranReading;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuranReadingRepository extends JpaRepository<QuranReading, Long> {
    List<QuranReading> findByUserId(Long userId);
}