package com.example.mykaretask.dto;

import com.example.mykaretask.model.User;
import lombok.Data;

@Data

public class UserDto {//It is used for user registration we need to get these information from user to create a account
    private String name;
    private String email;
    private  String password;
    private User.Gender gender;
}

