package com.muslimapp.muslimdailycompanion.controller;

import com.muslimapp.muslimdailycompanion.entity.ReadMeCard;
import com.muslimapp.muslimdailycompanion.repository.ReadMeCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/readme")
public class ReadMeCardController {

    @Autowired
    private ReadMeCardRepository readMeCardRepository;

    @PostMapping
    public ReadMeCard createCard(@RequestBody ReadMeCard card) {
        return readMeCardRepository.save(card);
    }

    @GetMapping
    public List<ReadMeCard> getAllCards() {
        return readMeCardRepository.findAll();
    }

    @GetMapping("/mood/{mood}")
    public ReadMeCard getCardByMood(@PathVariable String mood) {
        List<ReadMeCard> cards = readMeCardRepository.findByMood(mood);
        if (cards.isEmpty()) {
            throw new RuntimeException("No cards found for mood: " + mood);
        }
        Random random = new Random();
        return cards.get(random.nextInt(cards.size()));
    }

    @GetMapping("/surprise")
    public ReadMeCard getSurpriseCard() {
        List<ReadMeCard> allCards = readMeCardRepository.findAll();
        if (allCards.isEmpty()) {
            throw new RuntimeException("No cards available yet");
        }
        Random random = new Random();
        return allCards.get(random.nextInt(allCards.size()));
    }
}