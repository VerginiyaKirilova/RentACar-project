package com.example.project.convertor;

import com.example.project.dto.CarRequest;
import com.example.project.dto.CarResponse;
import com.example.project.entity.Car;
import org.springframework.stereotype.Component;

import java.util.Currency;

@Component
public class CarConvertor {
    public Car convertToCar (CarRequest carRequest){
        return Car.builder()
                .brand(carRequest.getBrand())
                .model(carRequest.getModel())
                .numberSeats(carRequest.getNumberSeats())
                .rentPrice(carRequest.getRentPrice())
                .build();
    }

    public CarResponse convertToCarResponse (Car car){
        return CarResponse.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .numberSeats(car.getNumberSeats())
                .rentPrice(car.getRentPrice())
                .build();
    }
}
