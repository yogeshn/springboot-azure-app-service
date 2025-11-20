package com.amock.helloazure.model;

import java.io.Serializable;

/**
 * Simple model class representing a name entity.
 * This class is designed to be serializable for potential use in distributed environments.
 * No deprecated APIs or sun.* packages are used, ensuring compatibility with Java 11 and later.
 */
public class MyName implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    /**
     * Default no-arg constructor for frameworks like Jackson or JPA.
     */
    public MyName() {
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

        return name != null ? name.equals(myName.name) : myName.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}