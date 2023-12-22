package com.example.semilore.exception;

import org.springframework.dao.IncorrectResultSizeDataAccessException;

public class SongException extends RuntimeException{
    public SongException(String message){
        super(message);
    }
    public SongException(String message, Throwable cause){
        super(message, cause);
    }

}
