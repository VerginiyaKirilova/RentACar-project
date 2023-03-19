package com.example.project.repository;

import com.example.project.dto.ReservationResponse;
import com.example.project.entity.Car;
import com.example.project.entity.Reservation;
import com.example.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
//    Optional<ReservationResponse> findByUser(Long id, User user);
//    Optional<ReservationResponse> findByCar(Long id, Car car);

    @Query(nativeQuery = true, value = "SELECT * FROM reservations WHERE pickUpDate BETWEEN ?1 AND ?2 OR returnDate BETWEEN ?1 AND ?2")
    List<Reservation> getReservationData (Instant dateReservation,Instant dateReturn);
}
