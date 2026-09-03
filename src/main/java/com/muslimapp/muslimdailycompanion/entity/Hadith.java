package com.muslimapp.muslimdailycompanion.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "hadiths")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hadith {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2000, nullable = false)
    private String text;

    private String narrator;

    private String source;

    private String category;
}