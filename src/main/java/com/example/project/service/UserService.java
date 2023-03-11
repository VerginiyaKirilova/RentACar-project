package com.example.project.service;

import com.example.project.dto.UserPasswordUpdate;
import com.example.project.dto.UserRequest;
import com.example.project.dto.UserResponse;
import com.example.project.entity.User;
import com.example.project.exception.RecordNotFoundException;

public interface UserService {
    UserResponse saveUser(UserRequest user);
    void updateUserPassword(UserPasswordUpdate userPasswordUpdate, Long id) throws RecordNotFoundException;
    UserResponse getUser(Long id);
    void deleteUser(Long id);
    User findByEmail(String email);
}
