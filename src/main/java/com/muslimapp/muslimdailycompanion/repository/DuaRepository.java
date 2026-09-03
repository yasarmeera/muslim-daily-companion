package com.muslimapp.muslimdailycompanion.repository;

import com.muslimapp.muslimdailycompanion.entity.Dua;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DuaRepository extends JpaRepository<Dua, Long> {
    List<Dua> findByCategory(String category);
}