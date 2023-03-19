package com.example.project.controller;

import com.example.project.convertor.ReservationConvertor;
import com.example.project.dto.*;
import com.example.project.entity.Car;
import com.example.project.entity.User;
import com.example.project.exception.RecordNotFoundException;
import com.example.project.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/reservation")
public class ReservationController {
    @Autowired
    ReservationService reservationService;
    @Autowired
    ReservationConvertor reservationConvertor;

    @PostMapping
    ResponseEntity<ReservationResponse> saveReservation (@Valid @RequestBody ReservationRequest reservationRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(reservationService.saveReservation(reservationRequest));
    }

    @PutMapping(path = "/update/{id}")
    ResponseEntity<String> updateReservationCar (@Valid @PathVariable  Long id, @RequestBody ReservationUpdate car) throws RecordNotFoundException {
        reservationService.updateReservationCar(car, id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("Reservation changed");
    }
    @PutMapping(path = "/update/data/{id}")
    ResponseEntity<String> updateReservationData (@Valid @PathVariable  Long id, @RequestBody ReservationUpdate data) throws RecordNotFoundException {
        reservationService.updateReservationData(data, id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("Reservation data is changed");
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<ReservationResponse> getReservation (@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(reservationService.getReservation(id));
    }
    @GetMapping(path = "/user/{id}")
    ResponseEntity<ReservationResponse> getReservationUser (@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(reservationService.getReservationUser(id, user));
    }
    @GetMapping(path = "/car/{id}")
    ResponseEntity<ReservationResponse> getReservationCar (@PathVariable Long id,@RequestBody Car car) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(reservationService.getReservationCar(id, car));
    }
    @GetMapping(path = "/data/{id}")
    ResponseEntity<ReservationResponse> getReservationData (@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(reservationService.getReservationData(id));
    }
    @DeleteMapping(path = "/{id}")
    ResponseEntity<String> deleteReservation(@PathVariable Long id){
        reservationService.deleteReservation(id);
        return ResponseEntity
                .ok()
                .body(String.format("%d deleted", id));
    }
}
