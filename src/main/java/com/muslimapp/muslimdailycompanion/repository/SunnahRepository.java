package com.muslimapp.muslimdailycompanion.repository;

import com.muslimapp.muslimdailycompanion.entity.Sunnah;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SunnahRepository extends JpaRepository<Sunnah, Long> {
    List<Sunnah> findByUserId(Long userId);
}