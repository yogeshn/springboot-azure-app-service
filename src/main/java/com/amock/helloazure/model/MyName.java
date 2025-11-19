package com.amock.helloazure.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyName {
    @JsonProperty("name")
    private String name;

    public MyName() {
        // Default constructor for JSON deserialization
    }

    public MyName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyName{" +
                "name='" + name + '\'' +
                '}';
    }

    // Equals and hashCode for consistency in tests
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