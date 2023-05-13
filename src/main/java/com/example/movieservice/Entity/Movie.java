package com.example.movieservice.Data.Model;

import com.example.movieservice.Data.Enum.Genre;
import lombok.Data;

import java.util.Date;

@Data
public class Movie {
    private int id;
    private String title;
    private Date releaseDate;
    private Genre genre;
}
