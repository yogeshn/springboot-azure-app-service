package com.amock.helloazure.model;

import java.io.Serializable;

/**
 * Simple model class representing a user's name.
 * Used for data transfer in the application, such as in REST responses or requests.
 * This class ensures basic validation and serialization for JSON handling in Spring Boot.
 */
public class MyName implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    /**
     * Default no-arg constructor for JSON deserialization.
     */
    public MyName() {
        // No-op for default instantiation
    }

    /**
     * Constructor with name initialization.
     * @param name The user's name to set.
     */
    public MyName(String name) {
        this.name = name;
    }

    /**
     * Gets the user's name.
     * @return The name as a String.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user's name.
     * Validates that the name is not null or empty to prevent invalid states.
     * @param name The name to set.
     * @throws IllegalArgumentException if name is null or empty.
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name.trim();
    }

    @Override
    public String toString() {
        return "MyName{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyName myName = (MyName) o;
        return java.util.Objects.equals(name, myName.name);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name);
    }
}