package com.example.semilore.dto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class SongDto {
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


}
