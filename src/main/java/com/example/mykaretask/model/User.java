package com.example.mykaretask.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {//this is the entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name field can not be empty")
    private String name;
    @Email(message = "Please Enter valid Email Id")//Also validated email
    @NotEmpty(message = "Email field can not be empty")
    @Column(unique = true)//By applying unique true there will be only one same email in the database so not possible to register same email id to register multiple times
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    public enum Gender{
        M,F,O //Male,Female,Others
    }
    private  String password;

}

