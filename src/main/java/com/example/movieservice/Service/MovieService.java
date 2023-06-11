package com.example.movieservice.Service;

import com.example.movieservice.Entity.Movie;
import com.example.movieservice.Exception.MovieNotFoundException;
import com.example.movieservice.Repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return movieRepository.save(movie);
    }

    public Movie update(long id, Movie updatedMovie) {
        var movieToUpdate = findById(id);

        updatedMovie.setId(movieToUpdate.getId());

        return movieRepository.save(updatedMovie);
    }


    public void delete(long id) {
        movieRepository.delete(findById(id));
    }

    public void setMovieAvailable(long id) {
        movieRepository.setMovieAvailable(findById(id).getId());
    }
}
