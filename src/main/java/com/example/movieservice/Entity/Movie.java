package com.example.movieservice.Entity;

import com.example.movieservice.Data.Enum.Genre;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private Date releaseDate;
    @Enumerated(EnumType.STRING)
    private Genre genre;
}
