package com.example.project.dto;

import lombok.*;


@Getter
@Setter
@Builder
public class UserResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
