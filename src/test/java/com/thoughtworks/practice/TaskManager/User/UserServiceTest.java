package com.thoughtworks.practice.TaskManager.User;

import com.thoughtworks.practice.TaskManager.Note.Note;
import com.thoughtworks.practice.TaskManager.Note.NoteRepository;
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
    private UserService userService;

    @Autowired
    private NoteRepository noteRepository;

    @BeforeEach
    public void tearDown(){
        userRepository.deleteAll();
        noteRepository.deleteAll();
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
        User userOne = new User("same@gmail.com","same","same22");
        User existingUser = userService.register(userOne);
        User savedUser = userService.getUser(existingUser.getId());
        Assertions.assertEquals("same",savedUser.getUserName());
    }

    @Test
    void shouldGetTwoUser() throws Exception {
        User userOne = new User("sam@gmail.com","sam","sam22");
        User existingUserOne = userService.register(userOne);
        User userTwo = new User("dany@gmail.com","dany","dany22");
        User existingUserTwo = userService.register(userTwo);
        User savedUserOne = userService.getUser(existingUserOne.getId());
        User savedUserTwo = userService.getUser(existingUserTwo.getId());

        Assertions.assertEquals("sam",savedUserOne.getUserName());
        Assertions.assertEquals("dany@gmail.com",savedUserTwo.getEmail());

    }

    @Test
    void userShouldAddNote() throws Exception {
        User userOne = new User("samira@gmail.com","samira","samira22");
        User savedUser = userService.register(userOne);
        Note note = new Note("Hobby","Yoga");
        Note newNote = userService.createNote(note,savedUser.getId());
        Assertions.assertEquals("Hobby",newNote.getTitle());
        Assertions.assertEquals("samira",savedUser.getUserName());
    }

}
