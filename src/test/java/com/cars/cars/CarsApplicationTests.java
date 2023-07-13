package com.cars.cars;

import com.cars.cars.controller.CarController;
import com.cars.cars.model.Car;
import com.cars.cars.repository.CarsRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CarControllerTest {

    @Mock
    private CarsRepo carRepository;

    @InjectMocks
    private CarController carController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddCar() {
        Car car = new Car();
        when(carRepository.save(car)).thenReturn(car);

        Car result = carController.addCar(car);

        assertEquals(car, result);
        verify(carRepository, times(1)).save(car);
    }

    @Test
    void testGetAllCars() {
        List<Car> cars = Arrays.asList(new Car(), new Car());
        when(carRepository.findAll()).thenReturn(cars);

        ResponseEntity<List<Car>> response = carController.getAllCars();

        assertEquals(cars, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(carRepository, times(1)).findAll();
    }

    @Test
    void testDeleteAllCars() {
        ResponseEntity<String> response = carController.deleteAllCars();

        assertEquals("All cars deleted successfully.", response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(carRepository, times(1)).deleteAll();
    }
}
