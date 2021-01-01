package com.horvat.movie.controller;

import com.horvat.movie.model.DBRestResponse;
import com.horvat.movie.model.Movie;
import com.horvat.movie.model.MovieDBRestResponse;
import com.horvat.movie.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.List;

/*
    https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/
    FOR THIS CODE I USED HELP FROM TUTORIAL IN THIS LINK
 */

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;


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

    @GetMapping("/netmovie")
    public List<MovieDBRestResponse> getMovies(){

        String url = "https://api.themoviedb.org/3/search/movie?api_key=c08268c8d5f9f7a1a056cc4a0657af09&query=Jack+Reacher";
        DBRestResponse dbRestResponse = restTemplate.getForObject(url, DBRestResponse.class);
        return dbRestResponse.getResults();
    }

    //c08268c8d5f9f7a1a056cc4a0657af09
    //https://api.themoviedb.org/3/movie/10?api_key=<<c08268c8d5f9f7a1a056cc4a0657af09>>

}
