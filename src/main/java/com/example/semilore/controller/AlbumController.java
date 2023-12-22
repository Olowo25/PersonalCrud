package com.example.semilore.controller;

import com.example.semilore.entity.Album;
import com.example.semilore.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping(value = {"/get/{albumId}"})
    public ResponseEntity<Optional<Album>> getAlbumById(@PathVariable Long albumId) {
        Optional thealbum = albumService.getAlbumById(albumId);
        return new ResponseEntity<>(thealbum, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<Album> createAlbum(@RequestBody Album album) {
        albumService.createAlbum(album);
        return new ResponseEntity<>(album, HttpStatus.CREATED);
    }

    @GetMapping("/getallAlbum")
    public ResponseEntity<List<Album>> getAllAlbums() {
        List<Album> albums = albumService.getAllAlbums();
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @DeleteMapping("deleteAlbum/{albumId}")
    public ResponseEntity deleteAlbum(@PathVariable Long albumId) {
        albumService.deleteAlbum(albumId);
        return new ResponseEntity(HttpStatus.OK);
    }
}