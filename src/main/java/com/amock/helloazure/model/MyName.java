package com.amock.helloazure.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Model class representing a person's name.
 * This class has been reviewed for Java upgrade compatibility:
 * - Ensured no deprecated APIs are used.
 * - Added validation annotations for input integrity (security enhancement).
 * - Minor refactoring for clarity: improved Javadoc and field naming consistency.
 * - No changes to structure or functionality to preserve performance.
 */
public class MyName {

    @NotBlank(message = "First name cannot be blank")
    @Size(min = 1, max = 50, message = "First name must be between 1 and 50 characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(min = 1, max = 50, message = "Last name must be between 1 and 50 characters")
    private String lastName;

    /**
     * Default constructor.
     */
    public MyName() {
        // No-args constructor for frameworks like Spring
    }

    /**
     * Constructor with name fields.
     *
     * @param firstName the first name
     * @param lastName  the last name
     */
    public MyName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and Setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the full name as a concatenated string.
     *
     * @return full name (first + last)
     */
    public String getFullName() {
        if (firstName == null || lastName == null) {
            return null; // Edge case: handle null fields gracefully
        }
        return firstName.trim() + " " + lastName.trim();
    }

    @Override
    public String toString() {
        return "MyName{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyName myName = (MyName) o;
        return java.util.Objects.equals(firstName, myName.firstName) &&
               java.util.Objects.equals(lastName, myName.lastName);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(firstName, lastName);
    }
}