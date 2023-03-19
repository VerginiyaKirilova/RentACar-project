package com.example.project.service.impl;

import com.example.project.convertor.ReservationConvertor;
import com.example.project.dto.ReservationRequest;
import com.example.project.dto.ReservationResponse;
import com.example.project.dto.ReservationUpdate;
import com.example.project.entity.Car;
import com.example.project.entity.Reservation;
import com.example.project.entity.User;
import com.example.project.exception.RecordNotFoundException;
import com.example.project.repository.ReservationRepository;
import com.example.project.service.ReservationService;
import com.example.project.service.UserService;
import com.example.project.util.ReservationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserService userService;
    private final CarServiceImpl carService;
    private final ReservationConvertor reservationConvertor;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, UserService userService, CarServiceImpl carService, ReservationConvertor reservationConvertor) {
        this.reservationRepository = reservationRepository;
        this.userService = userService;
        this.carService = carService;
        this.reservationConvertor = reservationConvertor;
    }
    public double RentPriceForPeriod(Instant dateReservation, Instant dateReturn){
        Car car = new Car();
        long result = ReservationUtil.compareReservation(dateReservation, dateReturn);
        double reservationList = result * car.getRentPrice();
        return reservationList;
    }
    @Override
    public ReservationResponse saveReservation(ReservationRequest reservationRequest) {
        Reservation reservationToBeSaved = reservationConvertor.convertToReservation(reservationRequest);
        return reservationConvertor.convertToReservationResponse(reservationRepository.save(reservationToBeSaved));
    }

    @Override
    public ReservationResponse getReservation(Long id) {
        return reservationConvertor.convertToReservationResponse(reservationRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Id %s not found", id))));
    }

    public ReservationResponse getReservationUser(Long id,User user) {
//      return reservationRepository.findByUser(id,user).orElseThrow(()->new UsernameNotFoundException("Reservation not found"));
return null;
    }

    @Override
    public ReservationResponse getReservationCar(Long id, Car car) {
//       return reservationRepository.findByCar(id,car).orElseThrow(()->new UsernameNotFoundException("Reservation not found"));
        return null;
    }

    @Override
    public ReservationResponse getReservationData(Long id) {
        return null;
    }

    @Override
    public Reservation updateReservationCar(ReservationUpdate car, Long id) throws RecordNotFoundException {
        Optional<Reservation> carsReservationUpdate = reservationRepository.findById(car.getId());
        if (carsReservationUpdate.isPresent()) {
            throw new RecordNotFoundException("Reservation not found or invalid credentials");
        } else {
            Reservation updateReservation = new Reservation();
            updateReservation.setCars(car.getCars());
            updateReservation.setUser(car.getUser());
            updateReservation.setDateReservation(car.getDateReservation());
            updateReservation.setDateReturn(car.getDateReturn());
            return reservationRepository.save(updateReservation);
        }
    }

    @Override
    public Car updateReservationData(ReservationUpdate car, Long id) throws RecordNotFoundException {
        return null;
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
