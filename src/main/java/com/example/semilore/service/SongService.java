package com.example.semilore.service;

import com.example.semilore.entity.Song;
import com.example.semilore.exception.DataPresentHandler;
import com.example.semilore.exception.SongException;
import com.example.semilore.repository.SongRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;

    public List<Song> getAllSongs()
    {
        List<Song> songs = songRepository.findAll();
        if(songs.isEmpty()){
            throw new SongException("Your song list is empty");
        }
        return songs;
    }

    public void createSong(Song song){
        Optional<Song> songs =
                songRepository.findSongByTitle(song.getTitle());
        if (songs.isPresent()){
            log.info("its taken");
            throw new DataPresentHandler("choose another title, the title " + song.getTitle() + " is taken", 7);
        }
        songRepository.save(song);
    }

    public Optional<Song> findSongByTitle(String title){
        Optional<Song> song = songRepository.findSongByTitle(title);
        if(song.isEmpty()){
            throw new SongException("song with title "+ title + " does not exist");
        }
        return song;
    }

    public Optional<Song> getSongById(Long songId)
    {
        Optional<Song> song =songRepository.findById(songId);
        if(song.isEmpty()){
            throw new SongException("song with id "+ songId + " does not exist");
        }
        return song;
    }

    public void deleteSong(Long songId) {
        boolean exists = songRepository.existsById(songId);
        if(!exists){
            throw new SongException(
              "song with id"+ " " + songId + " "+ "does not exist");
        }
        songRepository.deleteById(songId);
    }
}
