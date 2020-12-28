package com.horvat.movie.controller;

import com.horvat.movie.model.Movie;
import com.horvat.movie.repository.MovieRepository;
import com.horvat.movie.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
    https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/
    FOR THIS CODE I USED HELP FROM TUTORIAL IN THIS LINK
 */

@RestController
@RequestMapping("/api")
public class MovieController {


    @Autowired
 private IMovieService iMovieService;



    @GetMapping("/movie")
    public List<Movie> getAllMovies(){
       return iMovieService.getAllMovies();
    }
}
