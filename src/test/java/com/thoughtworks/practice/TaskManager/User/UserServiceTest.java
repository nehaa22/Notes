package com.thoughtworks.practice.TaskManager.User;

import com.thoughtworks.practice.TaskManager.Note.Note;
import com.thoughtworks.practice.TaskManager.Note.NoteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
    public void tearDown() {
        userRepository.deleteAll();
        noteRepository.deleteAll();
    }

    @Nested
    class createUser {

        @Test
        void shouldAddFirstUserToDatabase() {
            User userOne = new User("neha@gmail.com", "Neha", "neha22");
            User newUser = userService.register(userOne);
            assertEquals("neha@gmail.com", newUser.getEmail());
            assertNotNull(newUser);
        }

        @Test
        void shouldAddSecondUserToDatabase() {
            User userOne = new User("avani@gmail.com", "Avani", "avani22");
            User newUser = userService.register(userOne);
            assertEquals("avani@gmail.com", newUser.getEmail());
            assertNotNull(newUser);
        }

        @Test
        void shouldAddManyUserToDatabase() {
            User userOne = new User("tony@gmail.com", "Tony", "tony22");
            User newUserOne = userService.register(userOne);
            assertEquals("tony@gmail.com", newUserOne.getEmail());
            assertNotNull(newUserOne);

            User userTwo = new User("stark@gmail.com", "Stark", "stark22");
            User newUserTwo = userService.register(userTwo);
            assertEquals("stark@gmail.com", newUserTwo.getEmail());
            assertNotNull(newUserTwo);
        }
    }

    @Nested
    class ReadUser {

        @Test
        void shouldGetUser() throws Exception {
            User userOne = new User("same@gmail.com", "same", "same22");
            User existingUser = userService.register(userOne);
            User savedUser = userService.getUser(existingUser.getId());
            assertEquals("same", savedUser.getUserName());
        }

        @Test
        void shouldGetTwoUser() throws Exception {
            User userOne = new User("sam@gmail.com", "sam", "sam22");
            User existingUserOne = userService.register(userOne);
            User userTwo = new User("dany@gmail.com", "dany", "dany22");
            User existingUserTwo = userService.register(userTwo);
            User savedUserOne = userService.getUser(existingUserOne.getId());
            User savedUserTwo = userService.getUser(existingUserTwo.getId());

            assertEquals("sam", savedUserOne.getUserName());
            assertEquals("dany@gmail.com", savedUserTwo.getEmail());

        }
    }


    @Nested
    class DeleteUser {
        @Test
        void shouldDeleteUser() {
            User userOne = new User("arya@gmail.com", "arya", "arya22");
            User savedUser = userService.register(userOne);
            userService.delete(savedUser);
            assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername(userOne.getUserName()));
        }

        @Test
        void shouldDeleteTwoUser() {
            User userOne = new User("shivaji@gmail.com", "shivaji", "shivaji22");
            User userTwo = new User("bhavani@gmail.com", "bhavani", "bhavani22");
            User userThree = new User("raj@gmail.com", "raj", "raj22");
            User userFour = new User("baji@gmail.com", "baji", "baji22");

            User savedUserOne = userService.register(userOne);
            User savedUserTwo = userService.register(userTwo);
            User savedUserThree = userService.register(userThree);
            User savedUserFour = userService.register(userFour);

            userService.delete(savedUserOne);
            userService.delete(savedUserTwo);

            assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername(savedUserOne.getUserName()));
            assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername(savedUserTwo.getUserName()));

            assertEquals("raj", savedUserThree.getUserName());
            assertEquals("baji", savedUserFour.getUserName());

        }
    }

    @Nested
    class UpdateUser {

        @Test
        void shouldUpdateGivenUser() throws Exception {
            User user = new User("lannister@gmail.com", "shivaji", "shivaji22");
            User savedUser = userService.register(user);

            User updateUser = new User("shivaji@gmail.com", "shivajirao", "shivaji22");
            User updatedUser = userService.update(savedUser, updateUser);

            Assertions.assertEquals("shivajirao", updatedUser.getUserName());
            Assertions.assertEquals("shivaji@gmail.com", updatedUser.getEmail());
            Assertions.assertEquals(savedUser.getId(), updatedUser.getId());
        }

        @Test
        void shouldUpdatePasswordAndNameOfTwoUsers() throws Exception {
            User userOne = new User("virus@gmail.com", "virus", "virus22");
            User savedUserOne = userService.register(userOne);
            User userTwo = new User("bacteria@gmail.com", "bacteria", "bacteria22");
            User savedUserTwo = userService.register(userTwo);

            User updateUserOne = new User("virus@gmail.com", "virus", "virus222");
            User updateUserTwo = new User("bacteria@gmail.com", "deadbacteria", "bacteria22");

            User updatedUserOne = userService.update(savedUserOne, updateUserOne);
            User updatedUserTwo = userService.update(savedUserTwo, updateUserTwo);

            Assertions.assertEquals("virus222", updatedUserOne.getPassword());
            Assertions.assertEquals("deadbacteria", updatedUserTwo.getUserName());
            Assertions.assertEquals(savedUserOne.getId(), updatedUserOne.getId());
            Assertions.assertEquals(savedUserTwo.getId(), updatedUserTwo.getId());

        }
    }

    @Nested
    class CreateNote {

        @Test
        void userShouldAddNote() throws Exception {
            User userOne = new User("samira@gmail.com", "samira", "samira22");
            User savedUser = userService.register(userOne);
            Note note = new Note("Hobby", "Yoga");
            Note newNote = userService.createNote(note, savedUser.getId());
            assertEquals("Hobby", newNote.getTitle());
            assertEquals("samira", savedUser.getUserName());
        }

        @Test
        void userShouldAddTwoNote() throws Exception {
            User userOne = new User("jain@gmail.com", "jain", "jain22");
            User savedUser = userService.register(userOne);
            Note noteOne = new Note("Food", "Veg");
            Note noteTwo = new Note("God", "Mahaveer");
            Note newNoteOne = userService.createNote(noteOne, savedUser.getId());
            Note newNoteTwo = userService.createNote(noteTwo, savedUser.getId());

            assertEquals("Food", newNoteOne.getTitle());
            assertEquals("Mahaveer", newNoteTwo.getMatter());

            assertEquals("jain", savedUser.getUserName());
        }

        @Test
        void multipleUserShouldAddMultipleNote() throws Exception {
            User userOne = new User("jain@gmail.com", "jain", "jain22");
            User savedUserOne = userService.register(userOne);
            User userTwo = new User("saxena@gmail.com", "saxena", "saxena22");
            User savedUserTwo = userService.register(userTwo);
            User userThree = new User("palekar@gmail.com", "palekar", "palekar22");
            User savedUserThree = userService.register(userThree);

            Note noteOne = new Note("Location", "Bnagalore");
            Note noteTwo = new Note("Job", "Deloitte");
            Note noteThree = new Note("Home", "Yavatmal");
            Note noteFour = new Note("Interest", "Australia");

            Note newNoteOne = userService.createNote(noteOne, savedUserOne.getId());
            Note newNoteTwo = userService.createNote(noteTwo, savedUserTwo.getId());
            Note newNoteThree = userService.createNote(noteThree, savedUserThree.getId());
            Note newNoteFour = userService.createNote(noteFour, savedUserThree.getId());

            assertEquals("Location", newNoteOne.getTitle());
            assertEquals("Deloitte", newNoteTwo.getMatter());
            assertEquals("Yavatmal", newNoteThree.getMatter());
            assertEquals("Australia", newNoteFour.getMatter());

            assertEquals("jain", savedUserOne.getUserName());
            assertEquals("saxena", savedUserTwo.getUserName());

        }
    }
}


