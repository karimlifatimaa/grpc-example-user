package com.example.graphqlexample.service;

import com.example.graphqlexample.dto.UserRequest;
import com.example.graphqlexample.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest request);

    UserResponse getUserById(Long id);

    List<UserResponse> getAllUsers();

    UserResponse updateUser(Long id, UserRequest request);

    void deleteUser(Long id);
}


