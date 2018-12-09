package com.melissadbain.cheesemvc.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

    @NotNull
    @Size(min = 5, max = 15, message = "please keep your username between 5 and 15 characters")
    private String username;

    @Email(message = "Please enter a valid email")
    private String email;

    @NotNull(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotNull(message = "The passwords do not match")
    private String verifyPassword;
    
    private int userId;
    private static int nextId = 100;
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

    public String getVerifyPassword() {

        return verifyPassword;
    }

    public void setVerifyPassword(String aVerifyPassword) {

        verifyPassword = aVerifyPassword;
        checkPassword();
    }

    private void checkPassword() {

        if (password != null && verifyPassword != null && !password.equals(verifyPassword)) {

            verifyPassword = null;
        }
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