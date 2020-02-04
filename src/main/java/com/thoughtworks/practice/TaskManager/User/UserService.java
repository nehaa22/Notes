package com.thoughtworks.practice.TaskManager.User;

import com.thoughtworks.practice.TaskManager.Note.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

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


    public User fetch(Long userId) throws Exception {
        return userRepository.findById(userId).orElseThrow(Exception::new);
    }
}
