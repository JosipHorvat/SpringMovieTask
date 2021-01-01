package com.horvat.movie.service;

import com.horvat.movie.model.DBRestResponse;
import com.horvat.movie.model.MovieDBRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class NetMovieService implements INetMovieService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<MovieDBRestResponse> getAllMovies() {
        String url = "https://api.themoviedb.org/3/search/movie?api_key=c08268c8d5f9f7a1a056cc4a0657af09&query=Jack+Reacher";
        DBRestResponse dbRestResponse = restTemplate.getForObject(url, DBRestResponse.class);
        return dbRestResponse.getResults();

    }

    @Override
    public List<MovieDBRestResponse> findAllBySpecification(String search) {
        //https://www.baeldung.com/rest-api-search-language-spring-data-specifications
        String key = "c08268c8d5f9f7a1a056cc4a0657af09";
       String url = "https://api.themoviedb.org/3/search/movie?api_key="+ key+ "&query="+search;

        //String url = "https://api.themoviedb.org/3/search/movie?api_key="+ key+ "&query=Jack+Reacher";

        //proučiti na njihovoj stranici kako pretražiti film
        return restTemplate.getForObject(url, DBRestResponse.class).getResults();



    }

}
