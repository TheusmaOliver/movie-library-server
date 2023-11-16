package com.theusma.movielibrary.services;

import com.theusma.movielibrary.entities.Movie;
import com.theusma.movielibrary.repositories.MovieRepository;

public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }
}
