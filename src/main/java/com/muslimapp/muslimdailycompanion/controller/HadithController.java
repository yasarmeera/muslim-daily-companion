package com.muslimapp.muslimdailycompanion.controller;

import com.muslimapp.muslimdailycompanion.entity.Hadith;
import com.muslimapp.muslimdailycompanion.repository.HadithRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hadiths")
public class HadithController {

    @Autowired
    private HadithRepository hadithRepository;

    @PostMapping
    public Hadith createHadith(@RequestBody Hadith hadith) {
        return hadithRepository.save(hadith);
    }

    @GetMapping
    public List<Hadith> getAllHadiths() {
        return hadithRepository.findAll();
    }

    @GetMapping("/category/{category}")
    public List<Hadith> getByCategory(@PathVariable String category) {
        return hadithRepository.findByCategory(category);
    }
}