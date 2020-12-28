package com.horvat.movie.service;

import com.horvat.movie.model.Movie;
import com.horvat.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService{

    @Autowired
    private MovieRepository movieRepository;


    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
