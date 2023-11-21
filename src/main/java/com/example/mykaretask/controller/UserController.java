package com.example.mykaretask.controller;

import com.example.mykaretask.dto.DeleteDto;
import com.example.mykaretask.dto.LoginDto;
import com.example.mykaretask.dto.UserDto;
import com.example.mykaretask.dto.UserViewDto;
import com.example.mykaretask.response.AllResponse;
import com.example.mykaretask.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mykare")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")//To add new user to the DB
    public ResponseEntity<String> registration(@RequestBody UserDto userDto){
        return userService.registration(userDto);
    }
    @GetMapping("/userview")//To view total users that registered it will provide name,email,gender and id
    public List<UserViewDto> userview(){
        return userService.viewUser();

    }
    @PostMapping("/login")//To login the user by their login detail here we use email and password to login
    public ResponseEntity<?> loginuser(@RequestBody LoginDto loginDto){
        AllResponse loginResponse = userService.loginUser(loginDto);
        return ResponseEntity.ok(loginResponse);
    }
    @DeleteMapping("/delete")//By passing email to the body we can delete the user.
    public ResponseEntity<?> deleteuser(@RequestBody DeleteDto deleteDto){
        AllResponse loginResponse = userService.deleteUser(deleteDto);
        return ResponseEntity.ok(loginResponse);

    }

}
