package com.thoughtworks.practice.TaskManager;

import com.thoughtworks.practice.TaskManager.User.User;
import com.thoughtworks.practice.TaskManager.User.UserRepository;
import com.thoughtworks.practice.TaskManager.User.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDb(UserRepository userRepository,UserService userService){
        return args -> {
            if(userRepository.findByUserName("neha").isEmpty()) {
                User savedUser = userRepository.save(new User("neha@gmail.com","neha","neha22"));
               userService.register(savedUser);
            }
        };
    }
}
