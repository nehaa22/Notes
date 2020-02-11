package com.thoughtworks.practice.TaskManager.Note;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.thoughtworks.practice.TaskManager.User.User;
import com.thoughtworks.practice.TaskManager.User.UserRepository;
import com.thoughtworks.practice.TaskManager.User.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class NoteServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    NoteService noteService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    NoteRepository noteRepository;

    @BeforeEach
    public void tearDown() {
        userRepository.deleteAll();
        noteRepository.deleteAll();
    }

//    @Nested
//    class CreateNote {
//
//        @Test
//        void userShouldAddNote() throws Exception {
//            User userOne = new User("samira@gmail.com", "samira", "samira22");
//            User savedUser = userService.register(userOne);
//            Note note = new Note("Hobby", "Yoga");
//            Note newNote = noteService.createNote(note, savedUser.getId());
//            assertEquals("Hobby", newNote.getTitle());
//            assertEquals("samira", savedUser.getUserName());
//        }
//
//        @Test
//        void userShouldAddTwoNote() throws Exception {
//            User userOne = new User("nj@gmail.com", "nj", "nj22");
//            User savedUser = userService.register(userOne);
//            Note noteOne = new Note("Food", "Veg");
//            Note noteTwo = new Note("God", "Mahaveer");
//            Note newNoteOne = noteService.createNote(noteOne, savedUser.getId());
//            Note newNoteTwo = noteService.createNote(noteTwo, savedUser.getId());
//
//            assertEquals("Food", newNoteOne.getTitle());
//            assertEquals("Mahaveer", newNoteTwo.getMatter());
//
//            assertEquals("nj", savedUser.getUserName());
//        }
//
//        @Test
//        void multipleUserShouldAddMultipleNote() throws Exception {
//            User userOne = new User("jain@gmail.com", "jain", "jain22");
//            User savedUserOne = userService.register(userOne);
//            User userTwo = new User("saxena@gmail.com", "saxena", "saxena22");
//            User savedUserTwo = userService.register(userTwo);
//            User userThree = new User("palekar@gmail.com", "palekar", "palekar22");
//            User savedUserThree = userService.register(userThree);
//
//            Note noteOne = new Note("Location", "Bnagalore");
//            Note noteTwo = new Note("Job", "Deloitte");
//            Note noteThree = new Note("Home", "Yavatmal");
//            Note noteFour = new Note("Interest", "Australia");
//
//            Note newNoteOne = noteService.createNote(noteOne, savedUserOne.getId());
//            Note newNoteTwo = noteService.createNote(noteTwo, savedUserTwo.getId());
//            Note newNoteThree = noteService.createNote(noteThree, savedUserThree.getId());
//            Note newNoteFour = noteService.createNote(noteFour, savedUserThree.getId());
//
//            assertEquals("Location", newNoteOne.getTitle());
//            assertEquals("Deloitte", newNoteTwo.getMatter());
//            assertEquals("Yavatmal", newNoteThree.getMatter());
//            assertEquals("Australia", newNoteFour.getMatter());
//
//            assertEquals("jain", savedUserOne.getUserName());
//            assertEquals("saxena", savedUserTwo.getUserName());
//
//        }
//    }
//
//
//    @Nested
//    class ReadNote {
//        @Test
//        void shouldReadOneNote() throws Exception {
//
//            User user = new User("google@gmail.com", "google", "google22");
//            User savedUser = userService.register(user);
//
//            Note note = new Note("employee", "good at work");
//            Note savedNote = noteService.createNote(note, savedUser.getId());
//
//            Note existingNote = noteService.readNote(savedNote.getId(), savedUser.getId());
//            Assertions.assertEquals("employee", existingNote.getTitle());
//
//        }
//
//        @Test
//        void shouldReadAllNote() throws Exception {
//
//            User user = new User("yahoo@gmail.com", "yahoo", "yahoo22");
//            User savedUser = userService.register(user);
//
//            Note noteOne = new Note("time", "very quick");
//            Note savedNoteOne = noteService.createNote(noteOne, savedUser.getId());
//            Note noteOneTwo = new Note("speed", "faster than other");
//            Note savedNoteTwo = noteService.createNote(noteOneTwo, savedUser.getId());
//            Note noteThree = new Note("performance", "best than all others");
//
//            Note savedNoteThree = noteService.createNote(noteThree, savedUser.getId());
//
//            Assertions.assertEquals("time", savedNoteOne.getTitle());
//            Assertions.assertEquals("speed", savedNoteTwo.getTitle());
//            Assertions.assertEquals("performance", savedNoteThree.getTitle());
//
//            List<Note> savedNotes = noteService.readAllNotes(savedUser.getId());
//            Assertions.assertEquals(3, savedNotes.size());
//        }
//    }

    @Nested
    class UpdateNote{

//        @Test
//        void shouldUpdateNote() throws Exception {
//            User user = new User("uber@gmail.com", "uber", "uber22");
//            User savedUser = userService.register(user);
//
//            Note noteOne = new Note("driver", "good in nature");
//            Note savedNoteOne = noteService.createNote(noteOne, savedUser.getId());
//            Note noteOneTwo = new Note("behaviour", "kind and polite");
//            Note savedNoteTwo = noteService.createNote(noteOneTwo, savedUser.getId());
//
//            Assertions.assertEquals("good in nature", savedNoteOne.getMatter());
//            Assertions.assertEquals("kind and polite", savedNoteTwo.getMatter());
//
//            Note updateNoteOne = new Note("driver","Not good in nature");
//
//            Note updatedNote = noteService.updateNote(updateNoteOne,savedNoteOne.getId(),savedUser.getId());
//
//            Assertions.assertEquals("Not good in nature",updatedNote.getMatter());
//        }

        @Test
        void shouldUpdateTwoNotesOfTwoDifferentUsers() throws Exception {
            User userOne = new User("pune@gmail.com", "pune", "pune22");
            User savedUserOne = userService.register(userOne);
            User userTwo = new User("mumbai@gmail.com", "mumbai", "mumbai22");
            User savedUserTwo = userService.register(userTwo);

            Note noteOne = new Note("clean","first in maharashtra");
            Note savedNoteOne = noteService.createNote(noteOne,savedUserOne.getId());
            Note noteTwo = new Note("education","engineering famous");
            Note savedNoteTwo = noteService.createNote(noteTwo,savedUserOne.getId());

            Note noteThree = new Note("buildings","too high");
            Note savedNoteThree = noteService.createNote(noteThree,savedUserTwo.getId());
            Note noteFour = new Note("place","marin drive bandStand");
            Note savedNoteFour = noteService.createNote(noteFour,savedUserTwo.getId());

            Assertions.assertEquals("first in maharashtra", savedNoteOne.getMatter());
            Assertions.assertEquals("education", savedNoteTwo.getTitle());
            Assertions.assertEquals("buildings",savedNoteThree.getTitle());
            Assertions.assertEquals("marin drive bandStand",savedNoteFour.getMatter());

            Note updateNoteOne = new Note("cleanliness","Not first in Maharashtra");
            Note updateNoteThree = new Note("buildings","Taller than other cities");

            Note updatedNoteOne = noteService.updateNote(updateNoteOne,savedNoteOne.getId(),savedUserOne.getId());
            Note updatedNoteThree = noteService.updateNote(updateNoteThree,savedNoteThree.getId(),savedUserTwo.getId());

            Assertions.assertEquals("cleanliness", updatedNoteOne.getTitle());
            Assertions.assertEquals("Taller than other cities",updatedNoteThree.getMatter());

        }

    }
}


