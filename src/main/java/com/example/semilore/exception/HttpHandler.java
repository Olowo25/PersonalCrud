package com.example.semilore.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class HttpHandler extends ResponseEntityExceptionHandler {
//    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
// public ResponseEntity<SongExceptionEntity> HttpHandlerException(HttpRequestMethodNotSupportedException http){
//        String message = "check the rest type";
//        SongExceptionEntity see = new SongExceptionEntity(message,
//                HttpStatus.BAD_REQUEST,
//                ZonedDateTime.now(ZoneId.of("Z")));
//        return new ResponseEntity<>(see, HttpStatus.CONFLICT);
//    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers, HttpStatusCode status,
                                                                         WebRequest request) {
        String message = "check the http method type";
        SongExceptionEntity see = new SongExceptionEntity(message,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(see, HttpStatus.CONFLICT);
    }
}

