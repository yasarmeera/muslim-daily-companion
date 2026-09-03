package com.muslimapp.muslimdailycompanion.controller;

import com.muslimapp.muslimdailycompanion.entity.Dhikr;
import com.muslimapp.muslimdailycompanion.repository.DhikrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/dhikr")
public class DhikrController {

    @Autowired
    private DhikrRepository dhikrRepository;

    @PostMapping
    public Dhikr createDhikr(@RequestBody Dhikr dhikr) {
        return dhikrRepository.save(dhikr);
    }

    @GetMapping("/user/{userId}")
    public List<Dhikr> getDhikrByUser(@PathVariable Long userId) {
        return dhikrRepository.findByUserId(userId);
    }
}