package com.thoughtworks.practice.TaskManager.User;

import com.thoughtworks.practice.TaskManager.Note.Note;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(unique = true)
    private String email;

    @NotEmpty
    @Column
    private String userName;

    @Column
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Note> notes;

    public User(String email,String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public User(){}

    public Long getId(){ return  id; }

    public String getEmail(){
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void addNote(Note note) {
        this.notes.add(note);
        note.linkUser(this);
    }

    public void updateUsername(String updatedUsername) {
        this.userName = updatedUsername;
    }

    public void updateEmail(String updatedEmail) {
        this.email = updatedEmail;
    }

    public void updatePassword(String updatedPassword){
        this.password = updatedPassword;
    }
}
