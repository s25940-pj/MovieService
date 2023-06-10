package com.example.movieservice.Service;

import com.example.movieservice.Entity.Movie;
import com.example.movieservice.Repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie findById(Long id) {
        return movieRepository.findById(id).orElseThrow();
    }

    public Movie save(Movie movie) {
        var movieIsValid = validateMovie(movie);

        if (!movieIsValid) {
            throw new IllegalArgumentException("Invalid movie data. Please check the provided fields.");
        }

        return movieRepository.save(movie);
    }

    private boolean validateMovie(Movie movie) {
        if (movie.getTitle().isBlank()) {
            return false;
        }

        if (movie.getReleaseDate() == null) {
            return false;
        }

        if (movie.getGenre() == null) {
            return false;
        }

        return true;
    }

    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }
}
