package com.example.movieservice.Controller;

import com.example.movieservice.Entity.Movie;
import com.example.movieservice.Service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok(movieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findById(@PathVariable long id) {
        return ResponseEntity.ok(movieService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Movie> add(@RequestBody Movie movieToAdd) {
        return ResponseEntity.ok(movieService.add(movieToAdd));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> update(@PathVariable long id, @RequestBody Movie updatedMovie) {
        return ResponseEntity.ok(movieService.update(id, updatedMovie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        movieService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/set-available")
    public ResponseEntity<Void> setMovieAvailable(@PathVariable long id) {
        movieService.setMovieAvailable(id);

        return ResponseEntity.noContent().build();
    }
}
