package com.horvat.movie.service;

import com.horvat.movie.model.Movie;

import java.util.List;

public interface IMovieService {

    List<Movie> getAllMovies();

    List<Movie> findAllBySpecification(String search);

}
