package com.example.semilore.repository;

import com.example.semilore.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    List<Song> findByTitle(String title);

    @Query("SELECT sg FROM Song sg WHERE sg.title = ?1")
    Optional<Song> findSongByTitle( String title);
}
