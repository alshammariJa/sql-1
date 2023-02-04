package com.example.projjectweek4day4.Service;

import com.example.projjectweek4day4.ControllerAdvice.Api;
import com.example.projjectweek4day4.Module.Director;
import com.example.projjectweek4day4.Module.Movie;
import com.example.projjectweek4day4.Repository.DirectorRepository;
import com.example.projjectweek4day4.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;


    public List<Movie> getMovie(){
      return   movieRepository.findAll();
    }

    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }

    public void updateMovie( Integer id ,Movie movie){
       Movie  oldMovies= movieRepository.findUserById(id);
       if(oldMovies== null){
           throw new Api("wrong id") ;
       }
       oldMovies.setName(movie.getName());
       oldMovies.setGenre(movie.getGenre());
       oldMovies.setRating(movie.getRating());
       oldMovies.setDuration(movie.getDuration());
       oldMovies.setDirectorID(movie.getDirectorID());
       movieRepository.save(oldMovies);
    }

    public void deleteMovie(Integer id){
       movieRepository.deleteById(id);

    }

    public Movie findMovieByName(String name){
        Movie movie= movieRepository.findMovieByName(name);
        if(movie==null){
            throw new Api(" There is nothing here");
        }
        return movie;
    }

    public int returnDuration(String name ){
      Movie movie=   movieRepository.findMovieByName(name);

        if(movie==null){
            throw new Api("wrong the name of movie");
        }
        int movie1=  movie.getDuration();
        return movie1;
    }

    public  String returnDirector( String name){
        Movie movie=   movieRepository.findMovieByName(name);
        if(movie==null){
            throw new Api("wrong the name of movie");
        }
      Director director= directorRepository.findDirectorById(movie.getDirectorID());

        return director.getName();

    }


public List<Movie> findMovieByDirectorID(Integer id){
    List<Movie>movies=movieRepository.findMovieByDirectorID(id);

    if (movies==null){
        throw new Api("there is no movie with this director ");
    }

    return movies;
}



    public  int returnRate(String name){
        Movie movie=   movieRepository.findMovieByName(name);
        if(movie==null){
            throw new Api("wrong the name of movie");
        }
        int rate =movie.getRating();
        return rate;

    }




    public List<Movie> findAllByRatingGreaterThan(Integer rating) {
        List<Movie> movies = movieRepository.findAllByRatingGreaterThan(rating);
        if (movies == null) {
            throw new Api("wrong the name of movie");
        }
        return movies;
    }



    public List<Movie> findAllByGenre(String genre) {
        List<Movie> movies = movieRepository.findAllByGenreEquals(genre);
        if (movies == null) {
            throw new Api("this genre is not here");
        }
        return movies;
    }



}
