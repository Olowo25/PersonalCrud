package com.example.semilore.converter;

import com.example.semilore.dto.SongDto;
import com.example.semilore.entity.Song;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SongConverter {

    public SongDto entityToDto(Song song) {
        SongDto songDto = SongDto.builder().build();

        if (song != null) {
            BeanUtils.copyProperties(song, songDto);
        return songDto;
        }
        return songDto;
    }

    public List<SongDto>  entityToDto(List<Song> song){
        return song.stream().map(songs -> entityToDto(songs))
                .collect(Collectors.toList());
    }

    public Song dtoToEntity(SongDto songDto) {
        LocalDate date = LocalDate.now();
        Song song = Song.builder().releasedDate(date).build();
//        if (songDto != null) {
            BeanUtils.copyProperties(songDto, song);
            return song;
//        }
    }

    public List<Song> dtoToEntity(List<SongDto> songDto){
        return songDto.stream().map(songDtos -> dtoToEntity(songDtos))
                .collect(Collectors.toList());
    }
}
