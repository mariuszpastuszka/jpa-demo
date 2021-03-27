package com.sda.demo.model.enumeration;

public enum Colour {

    SILVER("silver midnight"),
    WHITE("white colour"),
    PINK("pinky");

    private final String description;

    public String getDescription() {
        return description;
    }

    Colour(String description) {
        this.description = description;
    }
}
