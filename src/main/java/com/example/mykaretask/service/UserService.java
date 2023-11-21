package com.example.mykaretask.service;

import com.example.mykaretask.dto.DeleteDto;
import com.example.mykaretask.dto.LoginDto;
import com.example.mykaretask.dto.UserDto;
import com.example.mykaretask.dto.UserViewDto;
import com.example.mykaretask.model.User;
import com.example.mykaretask.repository.UserRepository;
import com.example.mykaretask.response.AllResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public ResponseEntity<String> registration(UserDto userDto) { //Logic for registartion
        try {
            User user = new User();
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setGender(userDto.getGender());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            userRepository.save(user);
            return new ResponseEntity<>("Sucess", HttpStatus.OK);
        }catch (DataIntegrityViolationException e){
            return new ResponseEntity<>("Email is already registered", HttpStatus.CONFLICT);
        }catch (Exception e){
            return new ResponseEntity<>("Registration Failed", HttpStatus.BAD_REQUEST);
        }
    }

    public List<UserViewDto> viewUser() {//Logic to show registered users

        return userRepository.findAll().stream()
                .map(user -> {
                    UserViewDto userViewDto = new UserViewDto();
                    userViewDto.setId(user.getId());
                    userViewDto.setName(user.getName());
                    userViewDto.setEmail(user.getEmail());
                    userViewDto.setGender(user.getGender());
                    return userViewDto;
                })
                .collect(Collectors.toList());

    }


    public AllResponse loginUser(LoginDto loginDto) {//Logic for user login
        User user = userRepository.findByEmail(loginDto.getEmail());

        if (user != null) {
            String providedPassword = loginDto.getPassword();
            String storedEncodedPassword = user.getPassword();

            if (passwordEncoder.matches(providedPassword, storedEncodedPassword)) {
                return new AllResponse("Logged in", true);
            } else {
                return new AllResponse("Login failed: Incorrect password", false);
            }
        } else {
            return new AllResponse("Login failed: Email not found", false);
        }
    }

    public AllResponse deleteUser(DeleteDto deleteDto) {//Logic for delete user
        User user = userRepository.findByEmail(deleteDto.getEmail());
        if(user != null){
            userRepository.deleteById(user.getId());
            return new AllResponse("Deleted", true);
        }else {
            return new AllResponse("No user found" ,false);
        }
    }
}