package com.horvat.movie.model;

import java.io.Serializable;
import java.util.List;

public class DBRestResponse implements Serializable {

    private static final long serialVersionUID = -2234138101906568339L;
    private List<MovieDBRestResponse> results;

    public DBRestResponse() {
    }

    public List<MovieDBRestResponse> getResults() {
        return results;
    }

    public void setResults(List<MovieDBRestResponse> results) {
        this.results = results;
    }
}
