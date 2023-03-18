package com.example.project.controller;

import com.example.project.convertor.UserConvertor;
import com.example.project.dto.UserPasswordUpdate;
import com.example.project.dto.UserRequest;
import com.example.project.dto.UserResponse;
import com.example.project.exception.RecordNotFoundException;
import com.example.project.service.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserConvertor userConvertor;

    @PostMapping
    ResponseEntity<UserResponse> save (@RequestBody @Valid UserRequest userRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.saveUser(userRequest));
    }

    @PutMapping(path = "/password/{id}")
    ResponseEntity<String> updateUserPassword (@Valid @PathVariable Long id, @RequestBody UserPasswordUpdate user) throws RecordNotFoundException {
        userService.updateUserPassword(user, id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("Password changed");
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(userService.getUser(id));
    }

    @DeleteMapping(path = "/{id}")
    ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity
                .ok()
                .body(String.format("%d deleted", id));
    }
    @GetMapping(path = "/email/{email}")
    ResponseEntity<UserResponse> getByEmail (@PathVariable @Valid String email) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(userConvertor.toResponse(userService.findByEmail(email)));
    }
}
