package com.example.movieservice.ExceptionHandler;

import com.example.movieservice.Exception.MovieNotFoundException;
import com.example.movieservice.Exception.MovieNotValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<Void> handleMovieNotFound(MovieNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MovieNotValidException.class)
    public ResponseEntity<Void> handleMovieNotValid(MovieNotValidException exception) {
        return ResponseEntity.badRequest().build();
    }
}
