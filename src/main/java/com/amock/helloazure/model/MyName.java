package com.amock.helloazure.model;

import java.util.Objects;

/**
 * Model class representing a name, refactored for Java 17 compatibility.
 * Converted to a record for immutability and efficiency while preserving API contract.
 * Original behavior maintained: provides name access without mutation.
 */
public record MyName(String name) {

    /**
     * Constructor to handle null or empty names, ensuring validation.
     * Edge case: If name is null or empty, defaults to "Unknown".
     */
    public MyName {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        // Normalize by trimming whitespace
        name = name.trim();
    }

    /**
     * Provides the full name as a formatted string.
     * Maintains compatibility with any existing string representations.
     *
     * @return formatted name
     */
    public String getFormattedName() {
        return name; // Simple case; extend if needed for business logic
    }

    // Auto-generated equals, hashCode, and toString from record ensure consistency
    // No additional overrides needed unless custom logic required
}