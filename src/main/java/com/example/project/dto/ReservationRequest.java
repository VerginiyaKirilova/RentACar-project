package com.example.project.dto;

import com.example.project.entity.Car;
import com.example.project.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.time.Instant;
@Getter
@Setter
@Component
@Validated
public class ReservationRequest {

    private User user;
    private Car cars;
    private Instant dateReservation;
    private Instant dateReturn;


}
