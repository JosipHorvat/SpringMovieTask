package com.horvat.movie.controller;

import com.horvat.movie.model.Movie;
import com.horvat.movie.repository.MovieRepository;
import com.horvat.movie.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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



    @GetMapping("/movies")
    // localhost:8080/api/movie
    public List<Movie> getAllMovies(){
       return iMovieService.getAllMovies();
    }


    @GetMapping("/movie/")
    // EXAMPLE FOR POSTMAN:
    // localhost:8080/api/movie/?search=title:
    //localhost:8080/api/movie/?search=movieCategory:Horror
    //localhost:8080/api/movie/?search=length:100,movieCategory:Horror
   public ResponseEntity<List<Movie>> getMovieBySearchCriteria(@RequestParam String search){

        List<Movie> list = iMovieService.findAllBySpecification(search);
        return new ResponseEntity<List<Movie>>(list, HttpStatus.OK);
    }

}
