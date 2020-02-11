package com.thoughtworks.practice.TaskManager.Note;

import com.thoughtworks.practice.TaskManager.User.User;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String title;

    @Column
    String matter;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public int hashCode() {
        return 0;
    }

    public Note(){}

    public Note(String title,  String matter) {
        this.title = title;
        this.matter = matter;
    }
    public String getTitle() {
        return title;
    }

    public Long getId(){ return id; }

    public String getMatter() {
        return matter;
    }

    public void linkUser(User user) {
        this.user = user;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
