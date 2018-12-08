package com.melissadbain.cheesemvc.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Cheese {

    @NotNull
    @Size(min=3, max=20, message = "Please keep the cheese name between 3 and 20 characters")
    private String name;
    private String description;
    private int cheeseId;
    private static int nextId = 1;

    public Cheese(String aName, String aDescription) {
        this();
        name = aName;
        description = aDescription;
    }

    public Cheese() {
        cheeseId = nextId;
        nextId++;
    }

    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int aCheeseId) {
        cheeseId = aCheeseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String aDescription) {
        description = aDescription;
    }
}