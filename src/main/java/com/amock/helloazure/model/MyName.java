package com.amock.helloazure.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Model class representing a user's name, used in the Hello Azure application.
 * Updated for Java upgrade compatibility: Added Bean Validation annotations for input safety.
 * Ensures robustness by validating input at the model level to prevent invalid data propagation.
 * Handles edge cases such as empty strings or excessively long names through annotations.
 */
public class MyName {

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    private String name;

    /**
     * Default constructor for MyName.
     * Allows for default initialization, useful for testing and deserialization.
     */
    public MyName() {
        // Default constructor for flexibility in object creation
    }

    /**
     * Constructor with name parameter.
     * Initializes the name field directly, promoting immutability where possible.
     *
     * @param name the user's name to set
     */
    public MyName(String name) {
        this.name = name;
    }

    /**
     * Gets the name value.
     *
     * @return the name string
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name value.
     * Includes null check for robustness, though validation will catch invalid values later.
     *
     * @param name the name to set
     * @throws IllegalArgumentException if name is null (additional runtime safety)
     */
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
    }

    /**
     * Overrides toString for better debugging and logging.
     * Provides a clear representation of the object state.
     *
     * @return string representation of MyName
     */
    @Override
    public String toString() {
        return "MyName{" +
                "name='" + name + '\'' +
                '}';
    }

    /**
     * Overrides equals for proper object comparison.
     * Ensures correct equality checks based on name field, handling nulls safely.
     *
     * @param o the object to compare with
     * @return true if objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyName myName = (MyName) o;
        return name != null ? name.equals(myName.name) : myName.name == null;
    }

    /**
     * Overrides hashCode for consistent hashing with equals.
     * Uses name field for hash calculation, null-safe.
     *
     * @return hash code integer
     */
    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}