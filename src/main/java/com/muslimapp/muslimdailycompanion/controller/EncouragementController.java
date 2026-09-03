package com.muslimapp.muslimdailycompanion.controller;

import com.muslimapp.muslimdailycompanion.entity.Encouragement;
import com.muslimapp.muslimdailycompanion.repository.EncouragementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/encouragements")
public class EncouragementController {

    @Autowired
    private EncouragementRepository encouragementRepository;

    @PostMapping
    public Encouragement sendEncouragement(@RequestBody Encouragement encouragement) {
        return encouragementRepository.save(encouragement);
    }

    @GetMapping("/received/{userId}")
    public List<Encouragement> getReceivedEncouragements(@PathVariable Long userId) {
        return encouragementRepository.findByReceiverId(userId);
    }
}