package com.muslimapp.muslimdailycompanion.controller;

import com.muslimapp.muslimdailycompanion.entity.Dua;
import com.muslimapp.muslimdailycompanion.repository.DuaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/duas")
public class DuaController {

    @Autowired
    private DuaRepository duaRepository;

    @PostMapping
    public Dua createDua(@RequestBody Dua dua) {
        return duaRepository.save(dua);
    }

    @GetMapping
    public List<Dua> getAllDuas() {
        return duaRepository.findAll();
    }

    @GetMapping("/category/{category}")
    public List<Dua> getByCategory(@PathVariable String category) {
        return duaRepository.findByCategory(category);
    }
}