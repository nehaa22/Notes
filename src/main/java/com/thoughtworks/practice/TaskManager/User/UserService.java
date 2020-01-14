package com.thoughtworks.practice.TaskManager.User;

import com.thoughtworks.practice.TaskManager.Exception.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private
    UserRepository userRepository;

    public User register(User user) throws UserAlreadyExistException {

        Optional <User> existingUser = userRepository.findByEmail(user.getEmail());

        if(existingUser.isPresent()){
            throw new UserAlreadyExistException();
        }
        return userRepository.save(user);
    }
}
