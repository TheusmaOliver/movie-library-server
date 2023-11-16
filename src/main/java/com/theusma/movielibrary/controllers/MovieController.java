package com.theusma.movielibrary.controllers;

import com.theusma.movielibrary.entities.Movie;
import com.theusma.movielibrary.services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movies")
public class MovieController {
    private final MovieService movieService;


    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        var newMovie = movieService.addMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMovie);
    }
}
