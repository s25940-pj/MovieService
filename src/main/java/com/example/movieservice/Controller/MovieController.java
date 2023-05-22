package com.example.movieservice.Controller;

import com.example.movieservice.Entity.Movie;
import com.example.movieservice.Service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> findAll() {
        var movies = movieService.findAll();

        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findById(@PathVariable long id) {
        Movie movie = movieService.findById(id);

        return ResponseEntity.ok(movie);
    }

    @PostMapping("/add")
    public ResponseEntity<Movie> add(@RequestBody Movie movieToAdd) {
        var addedMovie = movieService.save(movieToAdd);

        return ResponseEntity.ok(addedMovie);
    }

    @PutMapping("/update")
    public ResponseEntity<Movie> update(@RequestBody Movie movieToUpdate) {
        var updatedMovie = movieService.save(movieToUpdate);

        return ResponseEntity.ok(updatedMovie);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody Movie movieToDelete) {
        movieService.delete(movieToDelete);

        return ResponseEntity.noContent().build();
    }
}
