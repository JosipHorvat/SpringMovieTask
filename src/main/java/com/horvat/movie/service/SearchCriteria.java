package com.horvat.movie.service;

public class SearchCriteria {
    /*
    For building search criteria i am using this tutorial:
    https://www.baeldung.com/rest-api-search-language-spring-data-specifications
    in tutorial there is no boolean orPredicate but it is needed with geters and seters.
     */


    private String key;
    private Object value;
    private String operation;
    private boolean orPredicate;

    public SearchCriteria(String key, String operation,Object value) {
        this.key = key;
        this.value = value;
        this.operation = operation;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public String getOperation() {
        return operation;
    }

    public boolean isOrPredicate() {
        return orPredicate;
    }

    public void setOrPredicate(boolean orPredicate) {
        this.orPredicate = orPredicate;
    }

}
