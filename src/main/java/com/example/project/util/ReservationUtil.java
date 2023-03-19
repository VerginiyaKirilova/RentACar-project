package com.example.project.util;


import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class ReservationUtil {

    public static long compareReservation(Instant dateReservation , Instant dateReturn) {
        Instant clientRentData = dateReservation.truncatedTo(ChronoUnit.DAYS);
        Instant clientReturnRentData = dateReturn.truncatedTo(ChronoUnit.DAYS);
        long daysElapsed = ChronoUnit.DAYS.between(clientRentData, clientReturnRentData);

         return daysElapsed;
    }
}
