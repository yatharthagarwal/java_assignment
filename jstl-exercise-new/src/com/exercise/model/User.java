package com.exercise.model;

public class User {
	
	private String username;
	private double creditLimit;
	
	public User() {
		
	}
	
	public User(String username, double creditLimit) {
		super();
		this.username = username;
		this.creditLimit = creditLimit;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", creditLimit=" + creditLimit + "]";
	}
}
