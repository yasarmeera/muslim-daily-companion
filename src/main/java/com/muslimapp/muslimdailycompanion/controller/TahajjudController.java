package com.muslimapp.muslimdailycompanion.controller;

import com.muslimapp.muslimdailycompanion.entity.Tahajjud;
import com.muslimapp.muslimdailycompanion.repository.TahajjudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tahajjud")
public class TahajjudController {

    @Autowired
    private TahajjudRepository tahajjudRepository;

    @PostMapping
    public Tahajjud createTahajjud(@RequestBody Tahajjud tahajjud) {
        return tahajjudRepository.save(tahajjud);
    }

    @GetMapping("/user/{userId}")
    public List<Tahajjud> getTahajjudByUser(@PathVariable Long userId) {
        return tahajjudRepository.findByUserId(userId);
    }
}