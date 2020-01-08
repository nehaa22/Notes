package com.thoughtworks.practice.TaskManager;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotEmpty
    @Column(unique = true)
    private String email;

    @NotEmpty
    @Column
    private String userName;


    @Column
    private String password;

    public User(String email,String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public User(){}

    public String getEmail(){
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
