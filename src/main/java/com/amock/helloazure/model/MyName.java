package com.amock.helloazure.model;

/**
 * MyName is a simple model class representing a name entity.
 * It encapsulates a single string field for the name value.
 * This class follows JavaBeans conventions for getter and setter methods.
 * Prioritizing performance and efficiency, it uses minimal overhead and avoids unnecessary complexity.
 */
public class MyName {

    private String name;

    /**
     * Gets the name value.
     *
     * @return the current name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name value.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}