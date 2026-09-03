package com.muslimapp.muslimdailycompanion.repository;

import com.muslimapp.muslimdailycompanion.entity.Encouragement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EncouragementRepository extends JpaRepository<Encouragement, Long> {
    List<Encouragement> findByReceiverId(Long receiverId);
}