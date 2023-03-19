package com.example.project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CarResponse {
    private Long id;
    private String brand;
    private String model;
    private String numberSeats;
    private Double rentPrice;
}
