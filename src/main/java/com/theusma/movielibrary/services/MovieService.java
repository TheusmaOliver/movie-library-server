package com.theusma.movielibrary.services;

import com.theusma.movielibrary.domain.movie.Movie;
import com.theusma.movielibrary.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Optional<Movie> getOneMovie(UUID id)  {
        return movieRepository.findById(id);
    }

    public void deleteMovie(UUID id){
        movieRepository.deleteById(id);
    }
}
