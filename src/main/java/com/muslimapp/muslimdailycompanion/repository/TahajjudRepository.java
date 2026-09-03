package com.muslimapp.muslimdailycompanion.repository;

import com.muslimapp.muslimdailycompanion.entity.Tahajjud;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TahajjudRepository extends JpaRepository<Tahajjud, Long> {
    List<Tahajjud> findByUserId(Long userId);
}