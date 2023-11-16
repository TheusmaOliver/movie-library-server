package com.theusma.movielibrary.services;

import com.theusma.movielibrary.entities.movie.Movie;
import com.theusma.movielibrary.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }
}
