package com.example.movieservice.Entity;

import com.example.movieservice.Data.Enum.Genre;
import lombok.Data;

import java.util.Date;

@Data
public class Movie {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private Date releaseDate;
//    @Enumerated(EnumType.STRING)
    private Genre genre;

    public Movie(String title) {
        this.title = title;
    }
}
