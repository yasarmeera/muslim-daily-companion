package com.muslimapp.muslimdailycompanion.repository;

import com.muslimapp.muslimdailycompanion.entity.ReadMeCard;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReadMeCardRepository extends JpaRepository<ReadMeCard, Long> {
    List<ReadMeCard> findByMood(String mood);
}