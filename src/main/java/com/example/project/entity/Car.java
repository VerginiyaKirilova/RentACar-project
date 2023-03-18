package com.example.project.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cars")
public class Car {
//    марка, модел, брой седалки, цена за наем на ден
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String brand;
    private String model;
    private String numberSeats;
    private Double rentPrice;

}
