package com.amock.helloazure.model;

import java.util.Objects;

/**
 * Model class representing a person's name.
 * This class holds first and last name information.
 * Compatible with Java 17, using standard POJO structure with null-safety checks.
 */
public class MyName {

    private String firstName;
    private String lastName;

    /**
     * Default constructor for MyName.
     * Initializes with empty strings to avoid null values.
     */
    public MyName() {
        this.firstName = "";
        this.lastName = "";
    }

    /**
     * Constructor with name parameters.
     * Validates inputs to prevent null or empty names for better data integrity.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @throws IllegalArgumentException if either name is null or empty after trimming
     */
    public MyName(String firstName, String lastName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
    }

    // Getter for firstName
    public String getFirstName() {
        return firstName;
    }

    // Setter for firstName with validation
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        this.firstName = firstName.trim();
    }

    // Getter for lastName
    public String getLastName() {
        return lastName;
    }

    // Setter for lastName with validation
    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
        this.lastName = lastName.trim();
    }

    /**
     * Returns the full name as a concatenated string.
     *
     * @return full name (first + last)
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * Checks if the name is considered empty (both fields are empty).
     *
     * @return true if both names are empty, false otherwise
     */
    public boolean isEmpty() {
        return firstName.trim().isEmpty() && lastName.trim().isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyName myName = (MyName) o;
        return Objects.equals(firstName, myName.firstName) &&
               Objects.equals(lastName, myName.lastName);
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
}