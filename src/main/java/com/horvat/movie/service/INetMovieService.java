package com.horvat.movie.service;

import com.horvat.movie.model.MovieDBRestResponse;

import java.util.List;

public interface INetMovieService {

    List<MovieDBRestResponse> getAllMovies();

    List<MovieDBRestResponse> findAllBySpecification(String search);
}
