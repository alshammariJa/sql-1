package com.example.projjectweek4day4.Repository;

import com.example.projjectweek4day4.Module.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository  extends JpaRepository<Director ,Integer> {
    Director findDirectorById(Integer id);
    Director findDirectorByName(String name);


}
