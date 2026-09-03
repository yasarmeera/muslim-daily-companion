package com.muslimapp.muslimdailycompanion.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "read_me_cards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReadMeCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String mood;

    @Column(length = 1000)
    private String quranVerse;

    private String quranReference;

    @Column(length = 1000)
    private String hadith;

    @Column(length = 1000)
    private String dua;

    @Column(length = 1000)
    private String reflection;
}