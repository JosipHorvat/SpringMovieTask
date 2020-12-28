package com.horvat.movie.service;

import com.horvat.movie.model.Movie;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class MovieSpecification implements Specification<Movie> {

//https://www.baeldung.com/rest-api-search-language-spring-data-specifications

    private SearchCriteria searchCriteria;

    public MovieSpecification(SearchCriteria searchCriteria){
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate
            (Root<Movie> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        if(searchCriteria.getOperation().equalsIgnoreCase(">")){
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.<String> get(searchCriteria.getKey()), searchCriteria.getValue().toString());
        }
        else if(searchCriteria.getOperation().equalsIgnoreCase("<")){
            return criteriaBuilder.lessThanOrEqualTo(
                    root.<String> get(searchCriteria.getKey()), searchCriteria.getValue().toString());
        }
        else if(searchCriteria.getOperation().equalsIgnoreCase(":")){
            if (root.get(searchCriteria.getKey()).getJavaType() == String.class) {
                return criteriaBuilder.like(
                        root.<String>get(searchCriteria.getKey()), "%" + searchCriteria.getValue() + "%");
            } else {
                return criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
            }
        }
        return null;
    }

}
