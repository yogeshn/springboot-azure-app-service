package com.amock.helloazure.model;

import java.io.Serializable;

/**
 * A simple model class representing a name.
 * This class is used in the HelloAzure application for handling name-related data.
 */
public class MyName implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    /**
     * Default constructor.
     */
    public MyName() {
    }

    /**
     * Constructor with name parameter.
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