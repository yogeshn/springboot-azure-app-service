package com.amock.helloazure.model;

import java.util.Objects;

/**
 * Model class representing a user's name.
 * This class holds the name value and provides basic validation and accessors.
 * Ensures robustness by validating non-empty names and handling null cases.
 */
public class MyName {

    private String name;

    /**
     * Default constructor for MyName.
     * Initializes with null name; validation occurs on set or get.
     */
    public MyName() {
        this.name = null;
    }

    /**
     * Constructor with name initialization.
     * Validates the provided name to ensure it is not null or empty.
     *
     * @param name the name to set
     * @throws IllegalArgumentException if name is null or empty after trimming
     */
    public MyName(String name) {
        setName(name); // Delegates to setter for validation
    }

    /**
     * Gets the name value.
     * Returns the trimmed name if valid; otherwise, throws an exception for robustness.
     *
     * @return the name
     * @throws IllegalStateException if name is null or empty
     */
    public String getName() {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("Name cannot be null or empty");
        }
        return name.trim();
    }

    /**
     * Sets the name value with validation.
     * Trims the input and checks for null/empty to prevent invalid states.
     *
     * @param name the name to set
     * @throws IllegalArgumentException if name is null or empty after trimming
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyName myName = (MyName) o;
        return Objects.equals(name, myName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "MyName{" +
                "name='" + name + '\'' +
                '}';
    }
}