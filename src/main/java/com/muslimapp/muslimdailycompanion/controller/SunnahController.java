package com.muslimapp.muslimdailycompanion.controller;

import com.muslimapp.muslimdailycompanion.entity.Sunnah;
import com.muslimapp.muslimdailycompanion.repository.SunnahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sunnah")
public class SunnahController {

    @Autowired
    private SunnahRepository sunnahRepository;

    @PostMapping
    public Sunnah createSunnah(@RequestBody Sunnah sunnah) {
        return sunnahRepository.save(sunnah);
    }

    @GetMapping("/user/{userId}")
    public List<Sunnah> getSunnahByUser(@PathVariable Long userId) {
        return sunnahRepository.findByUserId(userId);
    }
}