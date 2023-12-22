package com.example.semilore.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Transactional

public class Artist {
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
    private String password;
    private LocalDate dob;
    private Integer age;

    @ManyToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinTable(
            name = "artist_song_combo",
            joinColumns = {@JoinColumn (name = "artist_fk")},
            inverseJoinColumns = { @JoinColumn ( name = "song_fk")}
    )
    private Set<Song> song = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "artist")
    private List<Album> album = new ArrayList<>();

}