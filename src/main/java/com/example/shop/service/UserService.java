package com.example.shop.service;

import com.example.shop.dto.UserDto;
import com.example.shop.dto.request.UserRequest;

import java.util.List;

public interface    UserService {
    UserDto getUserById(Long id);
    void updateUser(UserRequest userRequest);
    void  saveUser (UserRequest userRequest);
    void  deleteUserById (Long id);
    List<UserDto> getAll();

}
