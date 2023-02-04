package com.example.projjectweek4day4.Controller;

import com.example.projjectweek4day4.Module.Movie;
import com.example.projjectweek4day4.Service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/get")
    public ResponseEntity getMovie(){
        List<Movie> movieList =movieService.getMovie();
        return ResponseEntity.status(200).body(movieList);
    }
    @PostMapping("/add")
    public ResponseEntity addMovie(@RequestBody Movie movie){
    movieService.addMovie(movie);
    return ResponseEntity.status(200).body("add done!");

    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateMovie(@PathVariable Integer id,  Movie movie ){
     movieService.updateMovie(id, movie);
        return  ResponseEntity.status(200).body("update done");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id){
      movieService.deleteMovie(id);
     return   ResponseEntity.status(200).body("delete done !");
    }

    @GetMapping("/name/{name}")
    public ResponseEntity findMovieByName(@PathVariable  String name){
    Movie movieList =movieService.findMovieByName(name);
    return ResponseEntity.status(200).body(movieList);
    }

  @GetMapping("/duration/{name}")
  public ResponseEntity MovieByDuration(@PathVariable  String name ){
    int movie =movieService.returnDuration(name);
      return ResponseEntity.status(200).body(movie);
  }

    @GetMapping("/{name}")
    public ResponseEntity MovieByDuraction(@PathVariable  String name){
        String duractorName = movieService.returnDirector(name);
        return ResponseEntity.status(200).body(duractorName);
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity findMovieByDirectorID(@PathVariable Integer id){
        List<Movie>movies=movieService.findMovieByDirectorID(id);
        return ResponseEntity.status(200).body(movies);
    }


  @GetMapping("/rate/{name}")

    public ResponseEntity MovieByRate(@PathVariable  String name){
        int movieRate= movieService.returnRate(name);
      return ResponseEntity.status(200).body(movieRate);

  }


    @GetMapping("/ratinggreater/{rating}")
    public ResponseEntity findAllByRatingGreaterThan(@PathVariable Integer rating){
        List<Movie> movie=movieService.findAllByRatingGreaterThan(rating);
        return ResponseEntity.status(200).body(movie);

    }


@GetMapping("/genre/{genre}")
public ResponseEntity findAllByGenreEquals(@PathVariable String genre){
    List<Movie> movie=movieService.findAllByGenre(genre);
    return ResponseEntity.status(200).body(movie);

}




}
