package com.example.projjectweek4day4.Module;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


//@Column(columnDefinition = "varchar(15) not null")
//@NonNull
//@Size(max = 2,message = "name must be greater then 2")
     private  String name;




//    @NonNull
//   @Column(columnDefinition = "varchar(50)  not null check( Validation='Drama' or Validation='Action' or Validation='Comedy')")
          private String genre;


//    @NonNull
//    @Column(columnDefinition = "not null ")
//    @Positive
    private int rating;


//    @NonNull
//    @Column(columnDefinition = " not null")
    private int duration;
//   @Column(columnDefinition = "not null ")
//   @NonNull
   private  int    directorID;
}
