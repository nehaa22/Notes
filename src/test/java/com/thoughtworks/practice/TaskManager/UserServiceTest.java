package com.thoughtworks.practice.TaskManager;

import com.thoughtworks.practice.TaskManager.Exception.UserAlreadyExistException;
import com.thoughtworks.practice.TaskManager.User.User;
import com.thoughtworks.practice.TaskManager.User.UserRepository;
import com.thoughtworks.practice.TaskManager.User.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserService userService ;

    @BeforeEach
    public void tearDown(){
        userRepository.deleteAll();
    }

    @Test
    void shouldAddFirstUserToDatabase() throws UserAlreadyExistException {
        User userOne = new User("nehaa@gmail.com","Neha","neha22");
        User newUser = userService.register(userOne);
        Assertions.assertEquals("nehaa@gmail.com",newUser.getEmail());
        Assertions.assertNotNull(newUser);
    }

    @Test
    void shouldAddSecondUserToDatabase() throws UserAlreadyExistException {
        User userOne = new User("avani@gmail.com","Avani","avani22");
        User newUser = userService.register(userOne);
        Assertions.assertEquals("avani@gmail.com",newUser.getEmail());
        Assertions.assertNotNull(newUser);
    }

    @Test
    void shouldAddManyUserToDatabase() throws UserAlreadyExistException {
        User userOne = new User("tony@gmail.com","Tony","tony22");
        User newUserOne = userService.register(userOne);
        Assertions.assertEquals("tony@gmail.com",newUserOne.getEmail());
        Assertions.assertNotNull(newUserOne);

        User userTwo = new User("stark@gmail.com","Stark","stark22");
        User newUserTwo = userService.register(userTwo);
        Assertions.assertEquals("stark@gmail.com",newUserTwo.getEmail());
        Assertions.assertNotNull(newUserTwo);
    }

    @Test
    void shouldAddOneUserToDatabase() throws UserAlreadyExistException {
        User userOne = new User("tani@gmail.com","Tani","tani22");
        User newUserOne = userService.register(userOne);
        Assertions.assertEquals("tani@gmail.com",newUserOne.getEmail());
        Assertions.assertNotNull(newUserOne);
    }

    @Test
    void shouldNotRegisterExistingUser() throws UserAlreadyExistException {
        User userOne = new User("tani@gmail.com","Tani","tani22");
        User newUserOne = userService.register(userOne);
        Assertions.assertEquals("tani@gmail.com",newUserOne.getEmail());
        Assertions.assertNotNull(newUserOne);
        User userTwo = new User("tani@gmail.com","Tani","tani22");
        Assertions.assertThrows( UserAlreadyExistException.class, () ->
                userService.register(userTwo)
        );
    }
}
