package com.thoughtworks.practice.TaskManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private
    UserRepository userRepository;


    public User register(User user) {
        return userRepository.save(user);
    }
}
