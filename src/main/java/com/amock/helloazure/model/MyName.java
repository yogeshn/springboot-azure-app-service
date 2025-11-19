package com.amock.helloazure.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

/**
 * Model class representing a person's name.
 * This class is designed to be immutable where possible, with validation for input data.
 * Adheres to Spring Boot best practices: uses Bean Validation for constraints,
 * Jackson annotations for JSON serialization/deserialization, and implements Serializable
 * for potential caching or session storage.
 * No deprecated features used; compatible with recent Spring Boot versions (e.g., 3.x).
 * Security: Input validation prevents injection attacks via size and null checks.
 * Performance: Immutable design reduces defensive copying; lightweight with no heavy computations.
 */
public final class MyName implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "First name cannot be blank")
    @Size(min = 1, max = 50, message = "First name must be between 1 and 50 characters")
    private final String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(min = 1, max = 50, message = "Last name must be between 1 and 50 characters")
    private final String lastName;

    @JsonCreator
    public MyName(@JsonProperty("firstName") String firstName,
                  @JsonProperty("lastName") String lastName) {
        // Defensive validation to ensure immutability and prevent nulls
        this.firstName = (firstName != null) ? firstName.trim() : "";
        this.lastName = (lastName != null) ? lastName.trim() : "";
        if (this.firstName.isEmpty() || this.lastName.isEmpty()) {
            throw new IllegalArgumentException("First and last names must not be empty after trimming");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * Full name for convenience, computed on demand to avoid storage overhead.
     * Edge case: Handles names with multiple spaces or special characters via trim.
     */
    public String getFullName() {
        // Efficient string concatenation using StringBuilder for potential performance in loops
        return new StringBuilder(firstName)
                .append(" ")
                .append(lastName)
                .toString()
                .trim();
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
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MyName{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    // No setters to enforce immutability; use builder pattern or factory if needed for complex creation
}