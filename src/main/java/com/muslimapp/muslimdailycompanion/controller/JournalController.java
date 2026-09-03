package com.muslimapp.muslimdailycompanion.controller;

import com.muslimapp.muslimdailycompanion.entity.Journal;
import com.muslimapp.muslimdailycompanion.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/journal")
public class JournalController {

    @Autowired
    private JournalRepository journalRepository;

    @PostMapping
    public Journal createEntry(@RequestBody Journal journal) {
        return journalRepository.save(journal);
    }

    @GetMapping("/user/{userId}")
    public List<Journal> getEntriesByUser(@PathVariable Long userId) {
        return journalRepository.findByUserId(userId);
    }

    @GetMapping("/user/{userId}/type/{entryType}")
    public List<Journal> getEntriesByType(@PathVariable Long userId, @PathVariable String entryType) {
        return journalRepository.findByUserIdAndEntryType(userId, entryType);
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        journalRepository.deleteById(id);
    }
}