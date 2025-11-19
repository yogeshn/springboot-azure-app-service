package com.amock.helloazure.model;

import java.io.Serializable;

/**
 * Simple model class representing a name.
 * This class holds a single string field for the name and provides
 * getter and setter methods. It implements Serializable for potential
 * serialization needs in the application.
 */
public class MyName implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    /**
     * Default constructor.
     */
    public MyName() {
        // No-op for default initialization
    }

    /**
     * Constructor with name initialization.
     *
     * @param name the name to set
     */
    public MyName(String name) {
        this.name = name;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyName{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyName myName = (MyName) o;
        return java.util.Objects.equals(name, myName.name);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name);
    }
}