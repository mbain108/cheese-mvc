package com.melissadbain.cheesemvc.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

    @NotNull
    @Size(min=5, max=15, message = "please keep your username between 5 and 20 characters")
    private String username;

    @NotNull
    @Size(min=8, message = "please enter a valid email")
    private String email;

    @NotNull
    @Size(min=8, message = "Password must be at least 8 characters long")
    private String password;

    private int userId;
    private static int nextId = 1000;
    private String joinDate;

    public User(String aUsername, String aEmail, String aPassword) {

        this();
        username = aUsername;
        email = aEmail;
        password = aPassword;
    }

    public User() {

        Date date = new Date();
        joinDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
        userId = nextId;
        nextId++;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String aUsername) {

        username = aUsername;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String aEmail) {

        email = aEmail;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String aPassword) {

        password = aPassword;
    }

    public int getUserId() {

        return userId;
    }

    private void setUserId(int aUserId) {

        userId = aUserId;
    }

    public String getJoinDate() {

        return joinDate;
    }

    private void setJoinDate(String aJoinDate) {

        joinDate = aJoinDate;
    }
}