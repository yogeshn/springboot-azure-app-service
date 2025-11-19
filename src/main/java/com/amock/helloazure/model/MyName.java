package com.amock.helloazure.model;

import java.util.Objects;

/**
 * A simple model class representing a person's name.
 * This class has been refactored for Java 11+ compatibility,
 * ensuring no deprecated APIs are used. Added validation for robustness
 * and proper null-safety. Maintains immutability where possible for thread-safety.
 */
public class MyName {
    private final String firstName;
    private final String lastName;

    /**
     * Constructor to initialize the name components.
     * Validates that names are non-null and non-empty to prevent invalid states.
     *
     * @param firstName the first name, must not be null or empty
     * @param lastName  the last name, must not be null or empty
     * @throws IllegalArgumentException if validation fails
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
     * Alternative constructor for backward compatibility, allowing nulls but defaulting to empty strings.
     * This handles edge cases where legacy code might pass null values.
     *
     * @param firstName the first name, may be null
     * @param lastName  the last name, may be null
     */
    public MyName(String firstName, String lastName, boolean allowNulls) {
        this.firstName = (firstName != null) ? firstName.trim() : "";
        this.lastName = (lastName != null) ? lastName.trim() : "";
        if (!allowNulls && (this.firstName.isEmpty() || this.lastName.isEmpty())) {
            throw new IllegalArgumentException("Names must not be empty when nulls are not allowed");
        }
    }

    // Getter for firstName
    public String getFirstName() {
        return firstName;
    }

    // Getter for lastName
    public String getLastName() {
        return lastName;
    }

    /**
     * Computes the full name by concatenating first and last names.
     * Handles edge cases where one part might be empty.
     *
     * @return the full name as a string
     */
    public String getFullName() {
        if (firstName.isEmpty() && lastName.isEmpty()) {
            return "";
        } else if (firstName.isEmpty()) {
            return lastName;
        } else if (lastName.isEmpty()) {
            return firstName;
        }
        return firstName + " " + lastName;
    }

    /**
     * Validates the name object for completeness.
     * Useful for business logic checks before processing.
     *
     * @return true if both names are non-empty, false otherwise
     */
    public boolean isValid() {
        return !firstName.isEmpty() && !lastName.isEmpty();
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
     * Builder pattern for creating MyName instances fluently.
     * Enhances readability and handles edge cases in construction.
     */
    public static class Builder {
        private String firstName = "";
        private String lastName = "";

        public Builder firstName(String firstName) {
            this.firstName = (firstName != null) ? firstName.trim() : "";
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = (lastName != null) ? lastName.trim() : "";
            return this;
        }

        /**
         * Builds the MyName instance, throwing an exception if validation fails.
         *
         * @return a new MyName instance
         * @throws IllegalStateException if required fields are invalid
         */
        public MyName build() {
            if (firstName.isEmpty() || lastName.isEmpty()) {
                throw new IllegalStateException("Both first and last names must be provided");
            }
            return new MyName(firstName, lastName);
        }
    }
}