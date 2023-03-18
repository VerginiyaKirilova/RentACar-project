package com.example.project.convertor;

import com.example.project.dto.UserRequest;
import com.example.project.dto.UserResponse;
import com.example.project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class UserConvertor {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    public User toUser(UserRequest userRequest){
        return User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .address(userRequest.getAddress())
                .email(userRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(userRequest.getPassword()))
                .build();
    }

    public UserResponse toResponse (User user){
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .address(user.getAddress())
                .email(user.getEmail())
                .build();

    }
}
