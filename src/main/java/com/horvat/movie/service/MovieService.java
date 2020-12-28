package com.horvat.movie.service;

import com.horvat.movie.model.Movie;
import com.horvat.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieRepository movieRepository;


    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> findAllBySpecification(String search) {
        //https://www.baeldung.com/rest-api-search-language-spring-data-specifications

        MovieSpecificationBuilder builder = new MovieSpecificationBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),", Pattern.UNICODE_CHARACTER_CLASS);
        // PATERN FOR ENGLISH LANGUAGE:  Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");

        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
          /*
         PATERNA
        Specification<Movie> movieSpecification = builder
                .with("name", ":", "Friday 13")
                .with("movieCategory" ,":","Drama")
                .with("length", ":", "180")
                .build();
         */

        Specification<Movie> movieSpec = builder.build();


        return movieRepository.findAll(movieSpec);
        }


    }

