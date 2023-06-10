package com.example.movieservice.Service;

import com.example.movieservice.Entity.Movie;
import com.example.movieservice.Exception.MovieNotFoundException;
import com.example.movieservice.Exception.MovieNotValidException;
import com.example.movieservice.Repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
    }

    public Movie add(Movie movie) {
        var movieIsValid = validateMovie(movie);

        if (!movieIsValid) {
            throw new MovieNotValidException();
        }

        return movieRepository.save(movie);
    }

    public Movie update(long id, Movie updatedMovie) {


        var movieToUpdate = findById(id);

        updatedMovie.setId(movieToUpdate.getId());

        return movieRepository.save(updatedMovie);
    }

    private boolean validateMovie(Movie movie) {
        if (movie.getTitle().isBlank()) {
            return false;
        }

        if (movie.getReleaseDate() == null) {
            return false;
        }

        return movie.getGenre() != null;
    }

    public void delete(long id) {
        movieRepository.delete(findById(id));
    }
}
