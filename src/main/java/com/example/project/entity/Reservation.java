package com.example.project.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "rsv")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @ManyToOne
    @JsonManagedReference
    private User user;

    @ManyToOne
    @JsonManagedReference
    private Car cars;

    private Instant dateReservation;

    private Instant dateReturn;

//    Резервацията представлява запис за резервация на кола от user-a. Съдържа информация за user-a, колата,
//    начална и крайна дата на резервацията. Цена на резервацията се калкулира въз основа на това
//    колко дни е резервацията и цената на резервацията на колата на ден. Дните трябва да се сметнат като разлика в датите.

}
