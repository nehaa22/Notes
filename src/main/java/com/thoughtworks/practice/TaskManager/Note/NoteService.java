package com.thoughtworks.practice.TaskManager.Note;

import com.thoughtworks.practice.TaskManager.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    public Note createNote(Note note ){
        return noteRepository.save(note);
    }

}
