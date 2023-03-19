package com.example.project.controller;

import com.example.project.dto.*;
import com.example.project.entity.Car;
import com.example.project.exception.RecordNotFoundException;
import com.example.project.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/car")
public class CarController {
    @Autowired
    CarService carService;


    @PostMapping
    ResponseEntity<CarResponse> save(@RequestBody @Valid CarRequest carRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(carService.saveCar(carRequest));
    }

    @PutMapping(path = "/update/{id}")
    ResponseEntity<String> updateCar (@Valid @PathVariable  Long id, @RequestBody CarUpdate car) throws RecordNotFoundException {
        carService.updateCar(car, id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("Car update");
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<CarResponse> getCar (@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(carService.getCar(id));
    }

    @DeleteMapping(path = "/{id}")
    ResponseEntity<String> deleteCar(@PathVariable Long id){
        carService.deleteCar(id);
        return ResponseEntity
                .ok()
                .body(String.format("%d deleted", id));
    }
}
