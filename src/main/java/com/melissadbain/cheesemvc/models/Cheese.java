package com.melissadbain.cheesemvc.models;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Cheese {

    @NotNull
    @Size(min = 3, max = 15, message = "Please keep the cheese name between 3 and 15 characters")
    private String name;

    @NotNull
    @Size(min = 1, message = "Description must not be empty")
    private String description;

    private CheeseType type;

    @NotNull
    @Range(min = 1, max = 5, message = "Please rate the cheese between 1 and 5 stars")
    private int rating;

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

    public CheeseType getType() {

        return type;
    }

    public void setType(CheeseType aType) {

        type = aType;
    }

    public int getRating() {

        return rating;
    }

    public void setRating(int aRating) {

        rating = aRating;
    }
}