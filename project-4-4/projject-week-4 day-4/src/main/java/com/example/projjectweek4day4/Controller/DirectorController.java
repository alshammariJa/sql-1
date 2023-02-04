package com.example.projjectweek4day4.Controller;

import com.example.projjectweek4day4.Module.Director;
import com.example.projjectweek4day4.Service.DirectorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/director")
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping("/get")
    public ResponseEntity  getDirector(){
        List<Director> directorList= directorService.getDirector();
        return ResponseEntity.status(200).body(directorList);
    }
    @PostMapping("/add")
    public ResponseEntity addDirector(@RequestBody Director director){
        directorService.addDirector(director);
        return ResponseEntity.status(200).body("added done!");

    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateDirector( Integer id ,Director director){
        directorService.updateDirector(id,director);
        return ResponseEntity.status(200).body("update done!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity DeleteDirector(Integer id ){
        directorService.deleteDirector(id);
        return ResponseEntity.status(200).body("deleted done");


    }




}
