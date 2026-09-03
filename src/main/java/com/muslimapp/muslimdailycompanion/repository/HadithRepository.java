package com.muslimapp.muslimdailycompanion.repository;

import com.muslimapp.muslimdailycompanion.entity.Hadith;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HadithRepository extends JpaRepository<Hadith, Long> {
    List<Hadith> findByCategory(String category);
}