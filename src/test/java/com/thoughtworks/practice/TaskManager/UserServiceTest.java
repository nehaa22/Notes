package com.thoughtworks.practice.TaskManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserService userService ;

    @Test
    void shouldAddUserToDatabase(){
        User userOne = new User("nehaa@gmail.com","Neha","neha22");
        User newUser = userService.register(userOne);
        Assertions.assertEquals("nehaa@gmail.com",newUser.getEmail());
        Assertions.assertNotNull(newUser);
    }

}
