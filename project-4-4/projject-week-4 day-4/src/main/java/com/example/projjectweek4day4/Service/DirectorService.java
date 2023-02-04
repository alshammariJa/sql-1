package com.example.projjectweek4day4.Service;

import com.example.projjectweek4day4.ControllerAdvice.Api;
import com.example.projjectweek4day4.Module.Director;
import com.example.projjectweek4day4.Module.Movie;
import com.example.projjectweek4day4.Repository.DirectorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DirectorService {
    private final DirectorRepository directorRepository;


    public List<Director> getDirector(){
        return  directorRepository.findAll();
    }

   public void addDirector(Director director){
       directorRepository.save(director);

   }
   public void updateDirector(Integer id ,Director director){
        Director oldDirector =directorRepository.findDirectorById(id);
        if(oldDirector ==null){
            throw new Api("wrong id");
        }
       oldDirector.setName(director.getName());
       directorRepository.save(oldDirector);
   }

   public void deleteDirector(Integer id){
        directorRepository.deleteById(id);
   }


}
