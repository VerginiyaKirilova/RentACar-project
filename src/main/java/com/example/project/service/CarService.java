package com.example.project.service;

import com.example.project.dto.*;
import com.example.project.entity.Car;
import com.example.project.exception.RecordNotFoundException;

public interface CarService {
    CarResponse saveCar(CarRequest car);
    void updateCar(CarUpdate car, Long id) throws RecordNotFoundException;
    CarResponse getCar(Long id);
    void deleteCar(Long id);
}
