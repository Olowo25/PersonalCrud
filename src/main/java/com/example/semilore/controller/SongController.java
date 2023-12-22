package com.example.semilore.controller;

import com.example.semilore.converter.SongConverter;
import com.example.semilore.dto.SongDto;
import com.example.semilore.entity.Song;
import com.example.semilore.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/song")
public class SongController {

    @Autowired
    private SongService songService;
    @Autowired
    private SongConverter songConverter;

    @GetMapping("/get/{songId}")
    public ResponseEntity<SongDto> getSongById(@PathVariable Long songId) {
        Song thesong = songService.getSongById(songId).orElse(null);
        SongDto songDto;
        songDto = songConverter.entityToDto(thesong);
        return new ResponseEntity<>( songDto, HttpStatus.CREATED);
    }

    @PostMapping("/create")
    public ResponseEntity<SongDto> createSong(@RequestBody SongDto songDto) {
        Song thesong;
        thesong = songConverter.dtoToEntity(songDto);
        songService.createSong(thesong);
        return new ResponseEntity<>(songDto, HttpStatus.CREATED);
    }

    @GetMapping("/getallSong")
    public ResponseEntity<List<SongDto>> getAllSongs() {
        List<Song> songs = songService.getAllSongs();
        List<SongDto> songDto;
        songDto = songConverter.entityToDto(songs);
        return new ResponseEntity<>(songDto, HttpStatus.CREATED);
    }

    @GetMapping("findSong/{title}")
    public Optional<Song> findSongTitle(@PathVariable String title){

        return songService.findSongByTitle(title);
    }

    @DeleteMapping("deleteSong/{songId}")
    public ResponseEntity removeSong(@PathVariable Long songId) {
        songService.deleteSong(songId);
        return new ResponseEntity(HttpStatus.OK);
    }
}