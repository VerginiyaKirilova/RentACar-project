package com.example.project.service.impl;

import com.example.project.convertor.CarConvertor;
import com.example.project.dto.CarRequest;
import com.example.project.dto.CarResponse;
import com.example.project.dto.CarUpdate;
import com.example.project.entity.Car;
import com.example.project.exception.RecordNotFoundException;
import com.example.project.repository.CarRepository;
import com.example.project.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarConvertor carConvertor;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, CarConvertor carConvertor) {
        this.carRepository = carRepository;
        this.carConvertor = carConvertor;
    }

    @Override
    public CarResponse saveCar(CarRequest carRequest) {
        Car carToBeSaved = carConvertor.convertToCar(carRequest);
        return carConvertor.convertToCarResponse(carRepository.save(carToBeSaved));
    }

    @Override
    public void updateCar(CarUpdate carUpdate, Long id) throws RecordNotFoundException {
        Optional<Car> carsUpdate = carRepository.findById(id);
        if (carsUpdate.isPresent()) {
            Car updateCar = carsUpdate.get();
            updateCar.setBrand(carUpdate.getBrand());
            updateCar.setModel(carUpdate.getModel());
            updateCar.setNumberSeats(carUpdate.getNumberSeats());
            updateCar.setRentPrice(carUpdate.getRentPrice());
            carRepository.save(updateCar);
       }
    }
    @Override
    public CarResponse getCar(Long id) {
        return carConvertor.convertToCarResponse(carRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Id %s not found", id))));
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

}
