package com.example.project.convertor;


import com.example.project.dto.ReservationRequest;
import com.example.project.dto.ReservationResponse;
import com.example.project.entity.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationConvertor {
    public Reservation convertToReservation (ReservationRequest reservationRequest){
        return Reservation.builder()
                .user(reservationRequest.getUser())
                .cars(reservationRequest.getCars())
                .dateReservation(reservationRequest.getDateReservation())
                .dateReturn(reservationRequest.getDateReturn())
                .build();
    }

    public ReservationResponse convertToReservationResponse (Reservation reservation){
        return ReservationResponse.builder()
                .id(reservation.getId())
                .user(reservation.getUser())
                .cars(reservation.getCars())
                .dateReservation(reservation.getDateReservation())
                .dateReturn(reservation.getDateReturn())
                .build();
    }
}
