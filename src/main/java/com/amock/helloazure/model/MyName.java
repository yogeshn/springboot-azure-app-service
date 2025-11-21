package com.amock.helloazure.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Model class representing a user's name.
 * Ensures backward compatibility with existing serialization.
 * Added Jackson annotations for consistent JSON handling.
 * Includes basic validation and logging for runtime compatibility.
 */
public class MyName {

    private static final Logger logger = LoggerFactory.getLogger(MyName.class);

    @JsonProperty("name")
    private String name;

    /**
     * Default constructor for backward compatibility and deserialization.
     */
    public MyName() {
        // No-op for compatibility
    }

    /**
     * Constructor with name initialization.
     * @param name The user's name.
     */
    public MyName(String name) {
        if (name == null || name.trim().isEmpty()) {
            logger.warn("Invalid name provided: null or empty. Using default.");
            this.name = "Unknown";
        } else {
            this.name = name.trim();
            logger.debug("MyName initialized with: {}", this.name);
        }
    }

    // Getter
    public String getName() {
        return name;
    }

    // Setter with validation
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            logger.warn("Attempted to set invalid name: null or empty.");
            this.name = "Unknown";
        } else {
            this.name = name.trim();
        }
    }

    @Override
    public String toString() {
        return "MyName{" +
                "name='" + name + '\'' +
                '}';
    }

    /**
     * Validates the name field.
     * @return true if valid, false otherwise.
     */
    public boolean isValid() {
        return name != null && !name.trim().isEmpty();
    }
}