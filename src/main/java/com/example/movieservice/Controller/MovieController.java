package com.example.movieservice.Controller;

import com.example.movieservice.Entity.Movie;
import com.example.movieservice.Service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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
    public ResponseEntity<?> findById(@PathVariable long id) {
        try {
            var movie = movieService.findById(id);

            return ResponseEntity.ok(movie);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Exception occured on request. Exception message: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Movie movieToAdd) {
        try {
            var addedMovie = movieService.save(movieToAdd);

            return ResponseEntity.ok(addedMovie);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Exception occured on request. Exception message: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody Movie movieToUpdate) {
        try {
            var movie = movieService.findById(id);

            movieToUpdate.setId(movie.getId());
            movieService.save(movieToUpdate);

            var updatedMovie = movieService.save(movieToUpdate);

            return ResponseEntity.ok(updatedMovie);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error: The requested movie for update could not be found.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        try {
            var movieToDelete = movieService.findById(id);

            movieService.delete(movieToDelete);

            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error: The requested movie for deletion could not be found.");
        }
    }
}
