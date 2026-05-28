package com.amock.helloazure.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Simple payload that represents a person's name. Instead of converting this
 * to a Java 21 {@code record}, we keep a traditional bean because the public
 * no-args constructor and mutators are still useful for some serialization
 * frameworks and reflection-based tooling used in Azure deployment scripts.
 *
 * The class is now immutable-by-default for improved thread-safety, while still
 * retaining Jackson compatibility through the {@link JsonCreator} annotated
 * constructor. Any older clients that relied on property names "firstName" and
 * "lastName" continue to operate as before.
 */
public class MyName {

    private final String firstName;
    private final String lastName;

    public MyName() {
        this("", "");
    }

    @JsonCreator
    public MyName(@JsonProperty("firstName") String firstName,
                  @JsonProperty("lastName") String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
