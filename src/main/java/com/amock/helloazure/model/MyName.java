package com.amock.helloazure.model;

/**
 * This class requires Java 17 as the minimum runtime version.
 */
public class MyName {

	private String firstName;
	private String lastName;
	
	public MyName() {
		super();
	}

	public MyName(String firstName, String lastName) {
		super();
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
}