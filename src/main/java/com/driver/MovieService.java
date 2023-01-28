package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie)
    {
        return movieRepository.addMovie(movie);
    }
    public String addDirector(Director director)
    {
        return movieRepository.addDirector(director);
    }
    public String addMovieDirectorPair(String nameMovie,String nameDirector)
    {
        return movieRepository.addMovieDirectorPair(nameMovie,nameDirector);
    }
    public Movie getMovieByName(String nameMovie)
    {
        return movieRepository.getMovieByName(nameMovie);
    }
    public Director getDirectorByName(String nameDirector)
    {
        return movieRepository.getDirectorByName(nameDirector);
    }
    public List<String> getMoviesByDirectorName(String nameDirector)
    {
        return movieRepository.getMoviesByDirectorName(nameDirector);
    }
    public List<String> findAllMovies()
    {
        return movieRepository.findAllMovies();
    }
    public String deleteDirectorByName(String nameDirector)
    {
        return movieRepository.deleteDirectorByName(nameDirector);
    }
    public String deleteAllDirectors()
    {
        return movieRepository.deleteAllDirectors();
    }
}
