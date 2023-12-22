package com.example.semilore.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Transactional
@Builder
public class Song {
    @Id
    @SequenceGenerator(
            name = "song_sequence",
            sequenceName = "song_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "song_sequence" )
    @Column(name = "song_id")
    private Long id;
    private String title;
    private String producer;
    private LocalDate releasedDate;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY , mappedBy = "song")
    private Set<Artist> artist = new HashSet<>();

}


