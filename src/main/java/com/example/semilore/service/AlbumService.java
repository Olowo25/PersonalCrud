package com.example.semilore.service;

import com.example.semilore.entity.Album;
import com.example.semilore.entity.Artist;
import com.example.semilore.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public void createAlbum(Album album){
        albumRepository.save(album);
    }

    public Optional<Album> getAlbumById(Long albumId){
        return albumRepository.findById(albumId);
    }

    public void deleteAlbum(Long albumId) {
        albumRepository.deleteById(albumId);
    }
}
