package com.example.semilore.dto;

import jakarta.persistence.*;

import java.time.LocalDate;

public class ArtistDto {
    @Id
    @SequenceGenerator(
            name = "Artist_sequence",
            sequenceName = "Artist_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "Artist_sequence" )
    @Column(name = "artist_id")
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;
}
