package com.example.shop.controller;

import com.example.shop.dto.UserDto;


import com.example.shop.dto.request.UserRequest;
import com.example.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RequiredArgsConstructor
    @RestController
    @RequestMapping(value = "/user")
    public class UserController{

        final UserService userService;

        @GetMapping(value="/allusers")
        public List<UserDto> getUserInfo(){
            return userService.getAll();
        }
        @GetMapping(value = "getUserById")
        public UserDto getUserById(@PathVariable(value = "id")Long id){
            return userService.getUserById(id);
        }
        @PostMapping(value = "/saveuser")
        public void saveUser(@RequestBody UserRequest userRequest){
            userService.saveUser(userRequest);
        }
        @PostMapping(value = "/updateUser")
        public void updateUser(@RequestBody UserRequest userRequest){
            userService.updateUser(userRequest);
        }
        @DeleteMapping(value = "/deleteUserById/{id}")
                public void deleteById(@PathVariable(value = "id")Long id){
            userService.deleteUserById(id);
        }
    }

