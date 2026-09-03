package com.muslimapp.muslimdailycompanion.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "duas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dua {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000, nullable = false)
    private String arabicText;

    @Column(length = 1000)
    private String translation;

    private String occasion;

    private String category;
}