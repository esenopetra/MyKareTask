package com.example.mykaretask.dto;

import com.example.mykaretask.model.User;
import lombok.Data;

@Data

public class UserViewDto {// We are only giving user id,name,email and gender
    private Integer id;
    private String name;
    private String email;
    private User.Gender gender;
}