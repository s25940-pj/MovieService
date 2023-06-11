package com.example.movieservice.Repository;

import com.example.movieservice.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("select m from Movie m where m.title = ?1")
    Movie findByTitle(String title);
    @Modifying
    @Transactional
    @Query("update Movie set isAvailable = true where id = ?1")
    void setMovieAvailable(long id);
}
