package com.amock.helloazure.model;

import java.util.Objects;

/**
 * Immutable model class representing a person's name.
 * This class prioritizes performance and efficiency by being immutable,
 * which avoids synchronization issues in multi-threaded environments and
 * allows for safe sharing of instances. It includes proper implementations
 * of equals, hashCode, and toString for efficient comparisons and hashing,
 * reducing overhead in collections like HashMap or HashSet.
 * 
 * Edge cases handled: null values are not allowed for firstName and lastName
 * to prevent NullPointerExceptions in usage; empty strings are permitted
 * but trim whitespace for consistency.
 */
public final class MyName {
    private final String firstName;
    private final String lastName;

    /**
     * Constructs a MyName instance with the given first and last names.
     * 
     * @param firstName the first name, must not be null
     * @param lastName the last name, must not be null
     * @throws IllegalArgumentException if firstName or lastName is null
     */
    public MyName(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("First name and last name cannot be null");
        }
        // Trim whitespace for consistency and to handle edge cases like leading/trailing spaces
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
    }

    /**
     * Gets the first name.
     * 
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name.
     * 
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the full name as a string.
     * 
     * @return the full name in "firstName lastName" format
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * Checks if the name is empty (both first and last names are empty strings).
     * 
     * @return true if both names are empty, false otherwise
     */
    public boolean isEmpty() {
        return firstName.isEmpty() && lastName.isEmpty();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyName myName = (MyName) obj;
        return Objects.equals(firstName, myName.firstName) &&
               Objects.equals(lastName, myName.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "MyName{firstName='" + firstName + "', lastName='" + lastName + "'}";
    }
}