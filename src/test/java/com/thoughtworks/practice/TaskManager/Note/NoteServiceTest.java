package com.thoughtworks.practice.TaskManager.Note;

import com.thoughtworks.practice.TaskManager.User.User;
import com.thoughtworks.practice.TaskManager.User.UserService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class NoteServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    NoteService noteService;

    @Nested
    class CreateNote {

        @Test
        void userShouldAddNote() throws Exception {
            User userOne = new User("samira@gmail.com", "samira", "samira22");
            User savedUser = userService.register(userOne);
            Note note = new Note("Hobby", "Yoga");
            Note newNote = noteService.createNote(note, savedUser.getId());
            assertEquals("Hobby", newNote.getTitle());
            assertEquals("samira", savedUser.getUserName());
        }

        @Test
        void userShouldAddTwoNote() throws Exception {
            User userOne = new User("nj@gmail.com", "nj", "nj22");
            User savedUser = userService.register(userOne);
            Note noteOne = new Note("Food", "Veg");
            Note noteTwo = new Note("God", "Mahaveer");
            Note newNoteOne = noteService.createNote(noteOne, savedUser.getId());
            Note newNoteTwo = noteService.createNote(noteTwo, savedUser.getId());

            assertEquals("Food", newNoteOne.getTitle());
            assertEquals("Mahaveer", newNoteTwo.getMatter());

            assertEquals("nj", savedUser.getUserName());
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

            Note newNoteOne = noteService.createNote(noteOne, savedUserOne.getId());
            Note newNoteTwo = noteService.createNote(noteTwo, savedUserTwo.getId());
            Note newNoteThree = noteService.createNote(noteThree, savedUserThree.getId());
            Note newNoteFour = noteService.createNote(noteFour, savedUserThree.getId());

            assertEquals("Location", newNoteOne.getTitle());
            assertEquals("Deloitte", newNoteTwo.getMatter());
            assertEquals("Yavatmal", newNoteThree.getMatter());
            assertEquals("Australia", newNoteFour.getMatter());

            assertEquals("jain", savedUserOne.getUserName());
            assertEquals("saxena", savedUserTwo.getUserName());

        }
    }

}
