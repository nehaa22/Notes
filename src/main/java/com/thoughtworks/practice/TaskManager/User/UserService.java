package com.thoughtworks.practice.TaskManager.User;

import com.thoughtworks.practice.TaskManager.Note.Note;
import com.thoughtworks.practice.TaskManager.Note.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    NoteRepository noteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user==null){
            throw new UsernameNotFoundException("Not found");
        }
        return new UserPrinciple(user);
    }

    public User register(User newUser)  {
        return userRepository.save(newUser);
    }

    public User getUser(Long userId) throws Exception {
        return userRepository.findById(userId).orElseThrow(Exception::new);
    }

    public Note createNote(Note note, Long userId) throws Exception {
        User existingUser = getUser(userId);
        existingUser.addNote(note);
        noteRepository.save(note);
        List<Note> notes = existingUser.getNotes();
        return notes.get(notes.size()-1);

    }
    public void delete(User savedUserOne) {
         userRepository.delete(savedUserOne);
    }
    public User update(User savedUser,User updateUser) throws Exception {
        User existingUser = getUser(savedUser.getId());

        if(existingUser != null){
            existingUser.updateUsername(updateUser.getUserName());
            existingUser.updateEmail(updateUser.getEmail());
            existingUser.updatePassword(updateUser.getPassword());
            return userRepository.save(existingUser);
        }
        else {
            throw new UserNotFoundException();
        }

    }
}
