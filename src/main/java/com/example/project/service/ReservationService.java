package com.example.project.service;

import com.example.project.dto.*;
import com.example.project.entity.Car;
import com.example.project.entity.Reservation;
import com.example.project.entity.User;
import com.example.project.exception.RecordNotFoundException;

public interface ReservationService {
    ReservationResponse saveReservation(ReservationRequest reservationRequest);
    ReservationResponse getReservation(Long id);
    ReservationResponse getReservationUser(Long id, User user);
    ReservationResponse getReservationCar(Long id, Car car);
    ReservationResponse getReservationData(Long id);
    Reservation updateReservationCar(ReservationUpdate car, Long id) throws RecordNotFoundException;
    Car updateReservationData(ReservationUpdate data, Long id) throws RecordNotFoundException;
    void deleteReservation(Long id);
}
