package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Repository
public class MovieRepository {
    Map<String, Movie> moviedb = new HashMap<>();
    Map<String, Director> directordb = new HashMap<>();
    Map<String, List<String>> pairdb = new HashMap<>();

    public String addMovie(Movie movie) {
        String name = movie.getName();
        moviedb.put(name, movie);
        return "Movie has been added successfully!!";
    }

    public String addDirector(Director director) {
        String name = director.getName();
        directordb.put(name, director);
        return "Director has been added successfully!!";
    }

    public String addMovieDirectorPair(String nameMovie, String nameDirector) {
        if(moviedb.containsKey(nameMovie) && directordb.containsKey(nameDirector)) {
            List<String> movieList = new ArrayList<>();
            if(pairdb.containsKey(nameDirector)) {
                if(pairdb.get(nameDirector).contains(nameMovie)) {
                    return "Pair already exist!";
                }
                movieList = pairdb.get(nameDirector);
                movieList.add(nameMovie);
                pairdb.put(nameDirector, movieList);
            } else {
                movieList.add(nameMovie);
                pairdb.put(nameDirector, movieList);
            }
            return "Pair has been added successfully!!";
        }
        return "Either Movie Name or Director Name doesn't exist in the DataBase!";
    }

    public Movie getMovieByName(String nameMovie) {
        if(moviedb.containsKey(nameMovie)) {
            return moviedb.get(nameMovie);
        }
        return null;
    }

    public Director getDirectorByName(String nameDirector) {
        if(directordb.containsKey(nameDirector)) {
            return directordb.get(nameDirector);
        }
        return null;
    }

    public List<String> getMoviesByDirectorName(String nameDirector) {
        if(pairdb.containsKey(nameDirector)) {
            return pairdb.get(nameDirector);
        }
        return null;
    }

    public List<String> findAllMovies() {
        List<String> movieList = new ArrayList<>();
        for(String name: moviedb.keySet()) {
            movieList.add(name);
        }
        return movieList;
    }

    public String deleteDirectorByName(String nameDirector) {
        List<String> movieList = new ArrayList<>();
        if(pairdb.containsKey(nameDirector)) {
            movieList = pairdb.get(nameDirector);
        }
        for(String movie: movieList) {
            if(moviedb.containsKey(movie)) {
                moviedb.remove(movie);
            }
        }
        pairdb.remove(nameDirector);
        if(directordb.containsKey(nameDirector)) {
            directordb.remove(nameDirector);
        }
        return "Director and all its movies are deleted successfully!!";
    }

    public String deleteAllDirectors() {
        for(String director: pairdb.keySet()) {
            List<String> movieList = pairdb.get(director);
            for(String movie: movieList) {
                if(moviedb.containsKey(movie)) {
                    moviedb.remove(movie);
                }
            }
            pairdb.remove(director);
        }
        for(String director: directordb.keySet()) {
            directordb.remove(director);
        }
        return "All Directors and all their movies has been deleted!!";
    }
}
