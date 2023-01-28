package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie) {
        String response = movieService.addMovie(movie);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping("/movies/add-director")
    public ResponseEntity addDirector(@RequestBody Director director) {
        String response = movieService.addDirector(director);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("nameMovie") String nameMovie, @RequestParam("nameDirector") String nameDirector) {
        String response = movieService.addMovieDirectorPair(nameMovie, nameDirector);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/movies/get-movie-by-name/{nameMovie}")
    public ResponseEntity getMovieByName(@PathVariable("nameMovie") String nameMovie)
    {
        Movie movie = movieService.getMovieByName(nameMovie);
        return new ResponseEntity<>(movie,HttpStatus.FOUND);
    }
    @GetMapping("/movies/get-director-by-name/{nameD}")
    public ResponseEntity getDirectorByName(@PathVariable("nameDirector") String nameDirector)
    {
        Director director = movieService.getDirectorByName(nameDirector);
        return new ResponseEntity<>(director,HttpStatus.FOUND);
    }
    @GetMapping("/movies/get-movies-by-director-name/{nameDirector}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("nameDirector") String nameDirector)
    {
        List<String> movieList = movieService.getMoviesByDirectorName(nameDirector);
        return new ResponseEntity<>(movieList,HttpStatus.FOUND);
    }
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity findAllMovies()
    {
        List<String> movieList = movieService.findAllMovies();
        return new ResponseEntity<>(movieList, HttpStatus.FOUND);
    }
    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("nameDirector") String nameDirector)
    {
        String response = movieService.deleteDirectorByName(nameDirector);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors()
    {
        String response = movieService.deleteAllDirectors();
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
