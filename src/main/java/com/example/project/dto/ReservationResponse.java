package com.example.project.dto;

import com.example.project.entity.Car;
import com.example.project.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
public class ReservationResponse {
    private Long id;
    private User user;
    private Car cars;
//    private Instant dateReservation;
//    private Instant dateReturn;
    private Double priceRent;
}
