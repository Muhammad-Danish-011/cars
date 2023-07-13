package com.cars.cars.model;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name="Cars")

public class Car {
   
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id ;
    private String thumbnail;
    private String name ;
    private String ShortDescription;
    private long RentalPrice;
   

}


