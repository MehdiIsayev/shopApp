package com.example.shop.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
    private Long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String address;
    private LocalDateTime creationtime;
    private LocalDateTime updatetime;
}
