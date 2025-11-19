package com.amock.helloazure.model;

import java.util.Objects;

/**
 * A simple model class representing a person's name.
 * This class has been refactored for modern Java practices:
 * - Uses immutable design where possible for thread-safety.
 * - Includes validation and error handling in constructors and methods.
 * - Replaces any potential anonymous classes with lambdas (none present originally).
 * - No deprecated APIs detected or used.
 * - Added null-safety checks and edge case handling.
 */
public class MyName {
    private final String firstName;
    private final String lastName;

    /**
     * Constructs a MyName instance with validation.
     *
     * @param firstName the first name, must not be null or empty
     * @param lastName  the last name, must not be null or empty
     * @throws IllegalArgumentException if firstName or lastName is null or empty after trimming
     */
    public MyName(String firstName, String lastName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name must not be null or empty");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name must not be null or empty");
        }
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
    }

    /**
     * Gets the first name.
     *
     * @return the first name, never null
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name, never null
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the full name by concatenating first and last name.
     *
     * @return the full name, e.g., "John Doe"
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * Validates if the name meets basic criteria (e.g., length).
     * Edge case: checks for excessively long names to prevent potential issues.
     *
     * @return true if valid, false otherwise
     */
    public boolean isValid() {
        try {
            validateNameLength(firstName, "First name");
            validateNameLength(lastName, "Last name");
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private void validateNameLength(String name, String fieldName) {
        if (name.length() > 100) { // Arbitrary max length for robustness
            throw new IllegalArgumentException(fieldName + " too long: " + name.length());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyName myName = (MyName) o;
        return firstName.equals(myName.firstName) && lastName.equals(myName.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "MyName{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    /**
     * Factory method to create MyName from a full name string.
     * Handles edge cases like missing parts or extra spaces.
     *
     * @param fullName the full name, e.g., "John Doe"
     * @return a new MyName instance, or throws exception if invalid
     * @throws IllegalArgumentException if fullName is invalid
     */
    public static MyName fromFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Full name must not be null or empty");
        }
        String[] parts = fullName.trim().split("\\s+", 2);
        if (parts.length < 2) {
            throw new IllegalArgumentException("Full name must contain at least first and last name");
        }
        return new MyName(parts[0], parts[1]);
    }
}