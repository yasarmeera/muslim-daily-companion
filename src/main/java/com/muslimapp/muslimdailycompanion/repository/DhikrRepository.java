package com.muslimapp.muslimdailycompanion.repository;

import com.muslimapp.muslimdailycompanion.entity.Dhikr;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DhikrRepository extends JpaRepository<Dhikr, Long> {
    List<Dhikr> findByUserId(Long userId);
}