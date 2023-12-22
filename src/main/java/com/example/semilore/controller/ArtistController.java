package com.example.semilore.controller;

import com.example.semilore.entity.Artist;
import com.example.semilore.repository.ArtistRepository;
import com.example.semilore.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;
    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping(value = {"/get/{artistId}"})
    public ResponseEntity<Optional<Artist>> getArtistById(@PathVariable Long artistId) {
        Optional the_artist = artistService.getArtistById(artistId);
        return new ResponseEntity<>(the_artist, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<Artist> createArtist(@RequestBody Artist artist) {
        artistService.createArtist(artist);
        return new ResponseEntity<>(artist, HttpStatus.CREATED);
    }

    @GetMapping("/getallArtist")
    public ResponseEntity<List<Artist>> getAllArtists() {
        List<Artist> artists = artistService.getAllArtists();
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @DeleteMapping("deleteArtist/{artistId}")
    public ResponseEntity removeArtist(@PathVariable Long artistId) {
        artistService.deleteArtist(artistId);
        return new ResponseEntity(HttpStatus.OK);
    }
}