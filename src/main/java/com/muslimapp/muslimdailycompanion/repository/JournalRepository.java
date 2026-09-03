package com.muslimapp.muslimdailycompanion.repository;

import com.muslimapp.muslimdailycompanion.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JournalRepository extends JpaRepository<Journal, Long> {
    List<Journal> findByUserId(Long userId);
    List<Journal> findByUserIdAndEntryType(Long userId, String entryType);
}