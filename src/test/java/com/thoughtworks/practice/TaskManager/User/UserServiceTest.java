package com.thoughtworks.practice.TaskManager.User;

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
    void shouldAddFirstUserToDatabase() {
        User userOne = new User("neha@gmail.com","Neha","neha22");
        User newUser = userService.register(userOne);
        Assertions.assertEquals("neha@gmail.com",newUser.getEmail());
        Assertions.assertNotNull(newUser);
    }

    @Test
    void shouldAddSecondUserToDatabase() {
        User userOne = new User("avani@gmail.com","Avani","avani22");
        User newUser = userService.register(userOne);
        Assertions.assertEquals("avani@gmail.com",newUser.getEmail());
        Assertions.assertNotNull(newUser);
    }

    @Test
    void shouldAddManyUserToDatabase()  {
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
    void shouldAddOneUserToDatabase() {
        User userOne = new User("tani@gmail.com","Tani","tani22");
        User newUserOne = userService.register(userOne);
        Assertions.assertEquals("tani@gmail.com",newUserOne.getEmail());
        Assertions.assertNotNull(newUserOne);
    }

    @Test
    void shouldAddNewOneUserToDatabase() {
        User userOne = new User("sam@gmail.com","sam","sam22");
        User newUserOne = userService.register(userOne);
        Assertions.assertEquals("sam@gmail.com",newUserOne.getEmail());
        Assertions.assertNotNull(newUserOne);
        User userTwo = new User("nancy@gmail.com","nancy","nancy22");
        User newUserTwo = userService.register(userTwo);
        Assertions.assertEquals("nancy@gmail.com",newUserTwo.getEmail());
        Assertions.assertNotNull(newUserTwo);
    }

    @Test
    void shouldGetUser() throws Exception {
        User userOne = new User("sam@gmail.com","sam","sam22");
        userService.register(userOne);
        User savedUser = userService.getUser(userOne.getId());
        Assertions.assertEquals("sam",savedUser.getUserName());
    }
}
