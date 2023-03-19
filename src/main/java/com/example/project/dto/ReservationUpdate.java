package com.example.project.dto;

import com.example.project.entity.Car;
import com.example.project.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReservationUpdate {
    private Long id;
    private User user;
    private Car cars;
    private Instant dateReservation;
    private Instant dateReturn;

}
