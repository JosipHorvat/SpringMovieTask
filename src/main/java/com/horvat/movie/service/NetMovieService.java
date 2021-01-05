package com.horvat.movie.service;

import com.horvat.movie.model.DBRestResponse;
import com.horvat.movie.model.MovieDBRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

        MovieSpecificationBuilder builder = new MovieSpecificationBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),", Pattern.UNICODE_CHARACTER_CLASS);
        // PATERN FOR ENGLISH LANGUAGE:  Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");

        String searchByTitle ="";
        while (matcher.find()) {
            if (matcher.group(1).equalsIgnoreCase("title")) {
                //pretraga po title
                searchByTitle = matcher.group(3);
            }
        }
       String url = "https://api.themoviedb.org/3/search/movie?api_key="+ key+ "&query="+searchByTitle;

        //proučiti na njihovoj stranici kako pretražiti film
        return restTemplate.getForObject(url, DBRestResponse.class).getResults();

    }

}
