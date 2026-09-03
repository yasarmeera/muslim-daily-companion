package com.muslimapp.muslimdailycompanion.controller;

import com.muslimapp.muslimdailycompanion.entity.Prayer;
import com.muslimapp.muslimdailycompanion.repository.PrayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/prayers")
public class PrayerController {

    @Autowired
    private PrayerRepository prayerRepository;

    @PostMapping
    public Prayer createPrayer(@RequestBody Prayer prayer) {
        return prayerRepository.save(prayer);
    }

    @GetMapping("/user/{userId}")
    public List<Prayer> getPrayersByUser(@PathVariable Long userId) {
        return prayerRepository.findByUserId(userId);
    }
}