package com.muslimapp.muslimdailycompanion.controller;

import com.muslimapp.muslimdailycompanion.entity.QuranReading;
import com.muslimapp.muslimdailycompanion.repository.QuranReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/quran")
public class QuranReadingController {

    @Autowired
    private QuranReadingRepository quranReadingRepository;

    @PostMapping
    public QuranReading createReading(@RequestBody QuranReading reading) {
        return quranReadingRepository.save(reading);
    }

    @GetMapping("/user/{userId}")
    public List<QuranReading> getReadingsByUser(@PathVariable Long userId) {
        return quranReadingRepository.findByUserId(userId);
    }
}