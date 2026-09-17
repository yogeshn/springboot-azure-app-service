package com.amock.helloazure.model;

import java.util.Objects;

/**
 * Model class representing a person's name.
 * 
 * Refactoring Applied:
 * - Added equals() and hashCode() methods for proper object comparison
 * - Added toString() method for debugging and logging
 * - Removed unnecessary super() calls in constructors
 * - Added null-safety considerations in equals/hashCode
 * - Maintained JavaBean compatibility for frameworks requiring getters/setters
 * - Compatible with Java 8+ (uses Objects utility class introduced in Java 7)
 */
public class MyName {

	private String firstName;
	private String lastName;
	
	public MyName() {
	}

	public MyName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MyName myName = (MyName) o;
		return Objects.equals(firstName, myName.firstName) &&
				Objects.equals(lastName, myName.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName);
	}

	@Override
	public String toString() {
		return "MyName{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}
}