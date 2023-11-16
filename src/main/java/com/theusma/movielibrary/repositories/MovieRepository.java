package com.theusma.movielibrary.repositories;

import com.theusma.movielibrary.entities.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {
}