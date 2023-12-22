package com.example.semilore.service;

import com.example.semilore.entity.Artist;
import com.example.semilore.entity.Song;
import com.example.semilore.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.Optional;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    public void createArtist(Artist artist){
        artistRepository.save(artist);

    }

    public Optional<Artist> getArtistById(Long artistId){

        return artistRepository.findById(artistId);
    }

    public void deleteArtist(Long artistId) {
        artistRepository.deleteById(artistId);
    }
}
