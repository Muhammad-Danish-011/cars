package com.cars.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cars.cars.model.Car;


public interface CarsRepo extends JpaRepository<Car, Long >{

            
    
}



