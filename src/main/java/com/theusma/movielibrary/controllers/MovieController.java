package com.theusma.movielibrary.controllers;

import com.theusma.movielibrary.domain.movie.Movie;
import com.theusma.movielibrary.domain.user.User;
import com.theusma.movielibrary.services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        var moviesList = movieService.getAllMovies();
        return ResponseEntity.status(HttpStatus.OK).body(moviesList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneMovie(@PathVariable(value = "id") UUID id) {
        Optional<Movie> movie = movieService.getOneMovie(id);
        return movie.<ResponseEntity<Object>>map(movieSelected -> ResponseEntity.status(HttpStatus.OK).body(movieSelected)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable(value = "id")UUID id){
        movieService.deleteMovie(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
