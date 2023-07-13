package com.cars.cars.controller;

import com.cars.cars.model.Car;
import com.cars.cars.repository.CarsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarsRepo carRepository;

    @Autowired
    public CarController(CarsRepo carRepository) {
        this.carRepository = carRepository;
    }

    @PostMapping("/add")
    public Car addCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return ResponseEntity.ok(cars);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAllCars() {
        carRepository.deleteAll();
        return ResponseEntity.ok("All cars deleted successfully.");
    }
}
