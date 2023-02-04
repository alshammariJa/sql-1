package com.example.projjectweek4day4.Repository;

import com.example.projjectweek4day4.Module.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie ,Integer> {
    Movie findUserById (Integer id);
    Movie findMovieByName(String Name );
  Movie findMoviesByDuration(Integer duration);

//  Movie findMoviesByGenre(String genre);
//  Movie findMoviesByGenre(List movie);




    List<Movie> findAllByRatingGreaterThan(Integer rating);

    List<Movie> findAllByGenreEquals(String genre);

    List<Movie> findMovieByDirectorID(Integer id);
}
