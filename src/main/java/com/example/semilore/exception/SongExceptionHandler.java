package com.example.semilore.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
@ControllerAdvice
public class SongExceptionHandler {
@ExceptionHandler( value = {SongException.class})
    public ResponseEntity<Object> ExceptionRequestHandler(SongException se){

        SongExceptionEntity see = new SongExceptionEntity(
                se.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
    return new ResponseEntity<>( see, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler( value = {DataPresentHandler.class})
    public ResponseEntity<Object> DataPresent(DataPresentHandler dph){

        SongExceptionEntity see = new SongExceptionEntity(
                dph.getMessage(),
                HttpStatus.IM_USED,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>( see, HttpStatus.IM_USED);
    }

}
