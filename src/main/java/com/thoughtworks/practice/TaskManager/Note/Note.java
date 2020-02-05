package com.thoughtworks.practice.TaskManager.Note;

import com.thoughtworks.practice.TaskManager.User.User;

import javax.persistence.*;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String title;

    @Column
    String matter;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public String getTitle() {
        return title;
    }

    public Long getId(){ return id; }

    public String getMatter() {
        return matter;
    }

    public Note(String title,  String matter) {
        this.title = title;
        this.matter = matter;
    }

    public void linkUser(User user) {
        this.user = user;
    }

    public Note(String title,  String matter, User user) {
        this.title = title;
        this.matter = matter;
        this.user = user;
    }

    public Note(){}
}
