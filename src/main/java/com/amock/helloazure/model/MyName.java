package com.amock.helloazure.model;

import java.util.Objects;

/**
 * Model class representing a name entity.
 * Updated to support Spring Boot 3.x and Java 17+ compatibility.
 */
public class MyName {

    private String firstName;
    private String lastName;
    private String middleName;

    /**
     * Default constructor required for serialization/deserialization.
     */
    public MyName() {
    }

    /**
     * Constructor with required fields.
     *
     * @param firstName the first name
     * @param lastName  the last name
     */
    public MyName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Full constructor with all fields.
     *
     * @param firstName  the first name
     * @param lastName   the last name
     * @param middleName the middle name
     */
    public MyName(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
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
     * Sets the first name.
     *
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
     * Sets the last name.
     *
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the middle name.
     *
     * @return the middle name
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets the middle name.
     *
     * @param middleName the middle name to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Returns the full name as a formatted string.
     * If middle name is present, it will be included between first and last name.
     *
     * @return formatted full name
     */
    public String getFullName() {
        if (middleName != null && !middleName.isEmpty()) {
            return firstName + " " + middleName + " " + lastName;
        }
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyName myName = (MyName) o;
        return Objects.equals(firstName, myName.firstName) &&
                Objects.equals(lastName, myName.lastName) &&
                Objects.equals(middleName, myName.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName);
    }

    @Override
    public String toString() {
        return "MyName{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                '}';
    }
}