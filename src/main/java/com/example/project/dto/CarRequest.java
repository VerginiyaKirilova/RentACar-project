package com.example.project.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Component
@Validated
public class CarRequest {

    private String brand;
    private String model;
    private String numberSeats;
    private Double rentPrice;

}
