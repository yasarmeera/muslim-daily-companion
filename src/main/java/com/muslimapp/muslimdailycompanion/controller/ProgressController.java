package com.muslimapp.muslimdailycompanion.controller;

import com.muslimapp.muslimdailycompanion.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {

    @Autowired
    private PrayerRepository prayerRepository;

    @Autowired
    private QuranReadingRepository quranReadingRepository;

    @Autowired
    private DhikrRepository dhikrRepository;

    @Autowired
    private SunnahRepository sunnahRepository;

    @Autowired
    private TahajjudRepository tahajjudRepository;

    @GetMapping("/today/{userId}")
    public Map<String, Object> getTodayProgress(@PathVariable Long userId) {
        LocalDate today = LocalDate.now();
        Map<String, Object> result = new HashMap<>();

        long prayersCompleted = prayerRepository.findByUserId(userId).stream()
                .filter(p -> p.getPrayerDate().equals(today) && p.isCompleted())
                .count();

        int quranPagesToday = quranReadingRepository.findByUserId(userId).stream()
                .filter(q -> q.getReadingDate().equals(today))
                .mapToInt(q -> q.getPagesRead())
                .sum();

        int dhikrCountToday = dhikrRepository.findByUserId(userId).stream()
                .filter(d -> d.getDhikrDate().equals(today))
                .mapToInt(d -> d.getCount())
                .sum();

        long sunnahCompletedToday = sunnahRepository.findByUserId(userId).stream()
                .filter(s -> s.getSunnahDate().equals(today) && s.isCompleted())
                .count();

        boolean tahajjudDoneToday = tahajjudRepository.findByUserId(userId).stream()
                .anyMatch(t -> t.getTahajjudDate().equals(today) && t.isCompleted());

        result.put("date", today);
        result.put("prayersCompleted", prayersCompleted);
        result.put("quranPagesToday", quranPagesToday);
        result.put("dhikrCountToday", dhikrCountToday);
        result.put("sunnahCompletedToday", sunnahCompletedToday);
        result.put("tahajjudDoneToday", tahajjudDoneToday);

        return result;
    }
}