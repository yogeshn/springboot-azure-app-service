package com.amock.helloazure.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Model class representing a user's name.
 * This class ensures robustness by validating the name field to prevent null, empty, or excessively long inputs.
 * It supports immutability where possible and includes proper error handling for validation.
 */
public class MyName {

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
    private String name;

    /**
     * Constructor with validation.
     * Throws IllegalArgumentException if validation fails (for cases where Bean Validation is not available).
     *
     * @param name the name to set
     */
    public MyName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (name.length() > 100) {
            throw new IllegalArgumentException("Name must not exceed 100 characters");
        }
        // Trim to handle leading/trailing whitespace as an edge case
        this.name = name.trim();
    }

    /**
     * Default constructor for frameworks like Jackson or Spring that require it.
     * Name is initialized to null; validation should be performed before use.
     */
    public MyName() {
        // No-op for framework compatibility
    }

    /**
     * Getter for the name field.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name field with validation.
     * Includes error handling to ensure the name meets criteria.
     *
     * @param name the name to set
     * @throws IllegalArgumentException if the name is invalid
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (name.length() > 100) {
            throw new IllegalArgumentException("Name must not exceed 100 characters");
        }
        this.name = name.trim();
    }

    /**
     * Validates the object state.
     * Useful for manual validation checks before processing.
     *
     * @return true if valid, false otherwise
     */
    public boolean isValid() {
        try {
            setName(this.name); // Re-validate current state
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Overrides toString for debugging/logging purposes.
     * Avoids exposing sensitive data if name were to contain PII, but here it's just name.
     *
     * @return string representation
     */
    @Override
    public String toString() {
        return "MyName{name='" + name + "'}";
    }

    /**
     * Equals method for object comparison, covering edge cases like null.
     *
     * @param o the object to compare
     * @return true if equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyName myName = (MyName) o;
        return name != null ? name.equals(myName.name) : myName.name == null;
    }

    /**
     * Hash code for consistent hashing.
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}