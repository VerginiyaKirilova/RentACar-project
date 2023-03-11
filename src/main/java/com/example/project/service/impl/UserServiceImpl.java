package com.example.project.service.impl;

import com.example.project.convertor.UserConvertor;
import com.example.project.dto.UserPasswordUpdate;
import com.example.project.dto.UserRequest;
import com.example.project.dto.UserResponse;
import com.example.project.entity.User;
import com.example.project.exception.RecordNotFoundException;
import com.example.project.repository.UserRepository;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConvertor userConvertor;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserConvertor userConvertor, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.userConvertor = userConvertor;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        User userToBeSaved = userConvertor.toUser(userRequest);
        return userConvertor.toResponse(userRepository.save(userToBeSaved));
    }
      @Override
    public void updateUserPassword(UserPasswordUpdate userPasswordUpdate , Long id) throws RecordNotFoundException {
        Optional<User> users = userRepository.findById(userPasswordUpdate.getId());
        if(users.isEmpty()){
            throw  new RecordNotFoundException("User not found or invalid credentials");
        } else if(!bCryptPasswordEncoder.matches(
                userPasswordUpdate.getPassword(),
                users.get().getPassword())){
            throw  new RecordNotFoundException("User not found or password is wrong");
        } else {
            users.get().setPassword(userPasswordUpdate.getPassword());
        }
    }

    @Override
    public UserResponse getUser(Long id) {
        return userConvertor.toResponse(userRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Id %s not found", id))));
    }
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("User not found"));
    }
}
