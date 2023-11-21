package com.example.mykaretask.dto;

import lombok.Data;

@Data

public class LoginDto {//dto for login. We can login to the account by giving email and password.
    private String email;
    private String password;
}
