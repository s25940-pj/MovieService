package com.example.movieservice.Service;

import com.example.movieservice.Entity.Movie;
import com.example.movieservice.Repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MovieService {
//    private final MovieRepository movieRepository;
//
//    public MovieService(MovieRepository movieRepository) {
//        this.movieRepository = movieRepository;
//    }
//
//    public Movie findById(Long id) {
//        try {
//            return movieRepository.findById(id).orElseThrow();
//        } catch (NoSuchElementException e) {
//            throw new NoSuchElementException();
//        }
//    }
//
//    public List<Movie> findAll() {
//        return movieRepository.findAll();
//    }
//
////    public Movie save(Movie movie) {
////        try {
////            return movieRepository.save(movie);
////        } catch (Exception) {
////            throw new Exception();
////        }
////    }
//
//    public void delete(Movie movie) {
//        movieRepository.delete(movie);
//    }
}
