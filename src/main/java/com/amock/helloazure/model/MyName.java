package com.amock.helloazure.model;

/**
 * MyName is a simple model class representing a name entity.
 * It encapsulates the name data and provides basic getter and setter methods.
 * This class is designed to be compatible with Java 17, using standard Java features.
 */
public class MyName {

    private String name;

    /**
     * Default constructor for MyName.
     * Initializes the name to null.
     */
    public MyName() {
    }

    /**
     * Constructor for MyName with a name parameter.
     * @param name the name to set
     */
    public MyName(String name) {
        this.name = name;
    }

    /**
     * Gets the name.
     * @return the current name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Override toString for better debugging and logging.
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "MyName{name='" + name + "'}";
    }

    /**
     * Override equals for proper object comparison.
     * @param o the object to compare with
     * @return true if objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyName myName = (MyName) o;
        return name != null ? name.equals(myName.name) : myName.name == null;
    }

    /**
     * Override hashCode for consistent hashing.
     * @return the hash code of the object
     */
    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}