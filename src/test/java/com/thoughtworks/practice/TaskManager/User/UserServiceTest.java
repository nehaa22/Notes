package com.thoughtworks.practice.TaskManager.User;

import com.thoughtworks.practice.TaskManager.Note.Note;
import com.thoughtworks.practice.TaskManager.Note.NoteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals("neha@gmail.com",newUser.getEmail());
        assertNotNull(newUser);
    }

    @Test
    void shouldAddSecondUserToDatabase() {
        User userOne = new User("avani@gmail.com","Avani","avani22");
        User newUser = userService.register(userOne);
        assertEquals("avani@gmail.com",newUser.getEmail());
        assertNotNull(newUser);
    }

    @Test
    void shouldAddManyUserToDatabase()  {
        User userOne = new User("tony@gmail.com","Tony","tony22");
        User newUserOne = userService.register(userOne);
        assertEquals("tony@gmail.com",newUserOne.getEmail());
        assertNotNull(newUserOne);

        User userTwo = new User("stark@gmail.com","Stark","stark22");
        User newUserTwo = userService.register(userTwo);
        assertEquals("stark@gmail.com",newUserTwo.getEmail());
        assertNotNull(newUserTwo);
    }

    @Test
    void shouldAddOneUserToDatabase() {
        User userOne = new User("tani@gmail.com","Tani","tani22");
        User newUserOne = userService.register(userOne);
        assertEquals("tani@gmail.com",newUserOne.getEmail());
        assertNotNull(newUserOne);
    }

    @Test
    void shouldAddNewOneUserToDatabase() {
        User userOne = new User("sam@gmail.com","sam","sam22");
        User newUserOne = userService.register(userOne);
        assertEquals("sam@gmail.com",newUserOne.getEmail());
        assertNotNull(newUserOne);
        User userTwo = new User("nancy@gmail.com","nancy","nancy22");
        User newUserTwo = userService.register(userTwo);
        assertEquals("nancy@gmail.com",newUserTwo.getEmail());
        assertNotNull(newUserTwo);
    }

    @Test
    void shouldGetUser() throws Exception {
        User userOne = new User("same@gmail.com","same","same22");
        User existingUser = userService.register(userOne);
        User savedUser = userService.getUser(existingUser.getId());
        assertEquals("same",savedUser.getUserName());
    }

    @Test
    void shouldGetTwoUser() throws Exception {
        User userOne = new User("sam@gmail.com","sam","sam22");
        User existingUserOne = userService.register(userOne);
        User userTwo = new User("dany@gmail.com","dany","dany22");
        User existingUserTwo = userService.register(userTwo);
        User savedUserOne = userService.getUser(existingUserOne.getId());
        User savedUserTwo = userService.getUser(existingUserTwo.getId());

        assertEquals("sam",savedUserOne.getUserName());
        assertEquals("dany@gmail.com",savedUserTwo.getEmail());

    }

    @Test
    void userShouldAddNote() throws Exception {
        User userOne = new User("samira@gmail.com","samira","samira22");
        User savedUser = userService.register(userOne);
        Note note = new Note("Hobby","Yoga");
        Note newNote = userService.createNote(note,savedUser.getId());
        assertEquals("Hobby",newNote.getTitle());
        assertEquals("samira",savedUser.getUserName());
    }

    @Test
    void userShouldAddTwoNote() throws Exception {
        User userOne = new User("jain@gmail.com","jain","jain22");
        User savedUser = userService.register(userOne);
        Note noteOne = new Note("Food","Veg");
        Note noteTwo = new Note("God","Mahaveer");
        Note newNoteOne = userService.createNote(noteOne,savedUser.getId());
        Note newNoteTwo = userService.createNote(noteTwo,savedUser.getId());

        assertEquals("Food",newNoteOne.getTitle());
        assertEquals("Mahaveer",newNoteTwo.getMatter());

        assertEquals("jain",savedUser.getUserName());
    }

    @Test
    void multipleUserShouldAddMultipleNote() throws Exception {
        User userOne = new User("jain@gmail.com","jain","jain22");
        User savedUserOne = userService.register(userOne);
        User userTwo = new User("saxena@gmail.com","saxena","saxena22");
        User savedUserTwo = userService.register(userTwo);
        User userThree = new User("palekar@gmail.com","palekar","palekar22");
        User savedUserThree = userService.register(userThree);

        Note noteOne = new Note("Location","Bnagalore");
        Note noteTwo = new Note("Job","Deloitte");
        Note noteThree = new Note("Home","Yavatmal");
        Note noteFour = new Note("Interest","Australia");

        Note newNoteOne = userService.createNote(noteOne,savedUserOne.getId());
        Note newNoteTwo = userService.createNote(noteTwo,savedUserTwo.getId());
        Note newNoteThree = userService.createNote(noteThree,savedUserThree.getId());
        Note newNoteFour = userService.createNote(noteFour,savedUserThree.getId());

        assertEquals("Location",newNoteOne.getTitle());
        assertEquals("Deloitte",newNoteTwo.getMatter());
        assertEquals("Yavatmal",newNoteThree.getMatter());
        assertEquals("Australia",newNoteFour.getMatter());

        assertEquals("jain",savedUserOne.getUserName());
        assertEquals("saxena",savedUserTwo.getUserName());

    }

    @Test
    void shouldDeleteUser() {
        User userOne = new User("arya@gmail.com","arya","arya22");
        User savedUser = userService.register(userOne);
        userService.deleteA(userOne);
        assertThrows(UsernameNotFoundException.class,()->userService.loadUserByUsername(savedUser.getUserName()));


    }
}
