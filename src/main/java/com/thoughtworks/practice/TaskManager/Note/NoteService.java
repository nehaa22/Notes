package com.thoughtworks.practice.TaskManager.Note;

import com.thoughtworks.practice.TaskManager.User.User;
import com.thoughtworks.practice.TaskManager.User.UserRepository;
import com.thoughtworks.practice.TaskManager.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    @Autowired
    UserService userService;

    public Note createNote(Note note, Long userId) throws Exception {
        User existingUser = userService.getUser(userId);
        existingUser.addNote(note);
        noteRepository.save(note);
        List<Note> notes = existingUser.getNotes();
        return notes.get(notes.size() - 1);

    }

}
