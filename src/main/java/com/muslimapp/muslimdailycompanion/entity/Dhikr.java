package com.muslimapp.muslimdailycompanion.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "dhikr")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dhikr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDate dhikrDate;

    @Column(nullable = false)
    private int count;

    private String dhikrType;
}