package com.example.shop.service.impl;

import com.example.shop.dto.UserDto;
import com.example.shop.dto.request.UserRequest;
import com.example.shop.entity.User;
import com.example.shop.repository.UserRepository;
import com.example.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.getUserById(id);
        return UserDto.builder()
                .username(user.getUsername())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .address(user.getAddress())
                .creationtime((LocalDateTime) user.getCreationtime())
                .updatetime((LocalDateTime) user.getUpdatetime())
                .build();


    }

    @Override
    public void updateUser(UserRequest userRequest) {
        User user = User.builder()
                .id(userRequest.getId())
                .username(userRequest.getUsername())
                .firstname(userRequest.getFirstname())
                .lastname(userRequest.getLastname())
                .address(userRequest.getAddress())
                .password(userRequest.getPassword())
                .updatetime(userRequest.getUpdatetime())
                .build();

    }

    @Override
    public void saveUser(UserRequest userRequest) {
        User user =User.builder()
                .username(userRequest.getUsername())
                .firstname(userRequest.getFirstname())
                .lastname(userRequest.getLastname())
                .address(userRequest.getAddress())
                .password(userRequest.getPassword())
                .creationtime(userRequest.getCreationtime())
                .build();

    }

    @Override
    public void deleteUserById(Long id) {
        User user = userRepository.getUserById(id);
                if(user==(null)){
                    throw new RuntimeException("bele id yoxdu");

                }else {
                    userRepository.deleteById(id);
                }

    }

    @Override
    public List<UserDto> getAll() {
        List<User> users=userRepository.findAll();
            List<UserDto>userDtos= new ArrayList<>();
            for (User user : users) {
                UserDto userDto = UserDto.builder()
                    .username(user.getUsername())
                    .firstname(user.getFirstname())
                    .lastname(user.getLastname())
                    .address(user.getAddress())
                    .creationtime(user.getCreationtime())
                    .updatetime(user.getUpdatetime())
                    .build();
        }
        return userDtos;
    }
}
