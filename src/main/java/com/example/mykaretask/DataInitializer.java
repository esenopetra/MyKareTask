package com.example.mykaretask;

import com.example.mykaretask.model.User;
import com.example.mykaretask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component

public class DataInitializer implements CommandLineRunner { //For the project currently using H2 DB so the data will be empty so if it is empty these data will be stored to the DB to check
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        initializeUsers();
    }

    private void initializeUsers() {
        if (userRepository.count() == 0) {
            User user1 = new User();
            user1.setName("John Doe");
            user1.setEmail("john.doe@example.com");
            user1.setPassword(passwordEncoder.encode("password234"));
            user1.setGender(User.Gender.M);
            userRepository.save(user1);

            User user2 = new User();
            user2.setName("Jane Doe");
            user2.setEmail("jane.doe@example.com");
            user2.setPassword(passwordEncoder.encode("password5644"));
            user2.setGender(User.Gender.F);
            userRepository.save(user2);

        }
    }
}