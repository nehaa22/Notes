package com.thoughtworks.practice.TaskManager.Note;

import com.thoughtworks.practice.TaskManager.User.User;
import com.thoughtworks.practice.TaskManager.User.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NoteTest {

    @Autowired
    UserService userService;

    @Autowired
    NoteService noteService;

    @Test
    void shouldAddNoteToUser(){
        User user = new User("ranka@gmail.com","Ranka","ranka22");
        userService.register(user);
        Note newNote = noteService.createNote(new Note("Sport","Best Sport Football"));
        Assertions.assertEquals("Sport",newNote.getTitle());
    }
}
