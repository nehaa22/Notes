package com.thoughtworks.practice.TaskManager.Note;

import com.thoughtworks.practice.TaskManager.User.User;
import com.thoughtworks.practice.TaskManager.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Note readNote(Long testNoteId, Long userId) throws NoteNotFoundException {
        List<Note> notes = noteRepository.findByUserId(userId);

        for (Note existingNote : notes) {
            if (existingNote.getId().equals(testNoteId)) {
                return existingNote;
            }
        }
        throw new NoteNotFoundException();
    }

    public List<Note> readAllNotes(Long userId) {
        return noteRepository.findByUserId(userId);

    }

    public Note updateNote(Note updateNote, Long noteId, Long userId) throws NoteNotFoundException {
        Note existingNote = readNote(noteId, userId);
        existingNote.setTitle(updateNote.getTitle());
        existingNote.setMatter(updateNote.getMatter());
        return noteRepository.save(existingNote);
    }

    public void deleteNote(Long userId, Long noteId) throws NoteNotFoundException {
        Note savedNote = readNote(noteId, userId);
        noteRepository.delete(savedNote);
    }
}
