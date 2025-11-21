package com.amock.helloazure.model;

import java.util.Objects;

/**
 * Model class representing a user's name.
 * This class holds the name value and provides basic validation to ensure
 * the name is not null or empty. It preserves the original structure
 * while adding robustness for error handling and edge cases like null inputs.
 */
public class MyName {

    private String name;

    /**
     * Constructor for MyName.
     * Validates that the provided name is not null or empty to prevent invalid states.
     *
     * @param name the name to set, must not be null or empty
     * @throws IllegalArgumentException if name is null or empty
     */
    public MyName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name.trim();
    }

    /**
     * Gets the name value.
     *
     * @return the name, guaranteed to be non-null and non-empty
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name value with validation.
     * This method handles edge cases by trimming whitespace and rejecting invalid inputs.
     *
     * @param name the name to set, must not be null or empty after trimming
     * @throws IllegalArgumentException if name is null or empty after trimming
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name.trim();
    }

    /**
     * Checks if this MyName is equal to another object.
     * Handles null checks and type safety for robustness.
     *
     * @param o the object to compare with
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyName myName = (MyName) o;
        return Objects.equals(name, myName.name);
    }

    /**
     * Generates a hash code for this MyName.
     * Ensures consistency with equals method.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * Returns a string representation of this MyName.
     * Useful for logging or debugging, handles null safety internally.
     *
     * @return string representation
     */
    @Override
    public String toString() {
        return "MyName{" +
                "name='" + name + '\'' +
                '}';
    }
}