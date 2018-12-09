package com.melissadbain.cheesemvc.models;

import java.util.ArrayList;

public class UserData {

    static ArrayList<User> users = new ArrayList<>();

    // getAll
    public static ArrayList<User> getAll() {

        return users;
    }

    // add
    public static void add(User newUser) {

        users.add(newUser);
    }

    // remove
    public static void remove(int userId) {

        User userToRemove = getByUserId(userId);
        users.remove(userToRemove);
    }

    // getById
    public static User getByUserId(int userId) {

        User theUser = null;

        for (User candidate : users) {

            if (candidate.getUserId() == userId) {

                theUser = candidate;
            }
        }

        return theUser;
    }
}