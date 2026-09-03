package com.muslimapp.muslimdailycompanion.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "quran_readings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuranReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDate readingDate;

    @Column(nullable = false)
    private int pagesRead;

    private String surahName;
}