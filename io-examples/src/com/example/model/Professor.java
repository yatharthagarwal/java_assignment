package com.example.model;

import java.io.Serializable;

public class Professor implements Serializable{

	private int id;
	private String firstName;
	private String department;
	private transient String qualification;
	
	public Professor() {
	
	}
	
	public Professor(int id, String firstName, String department, String qualification) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.department = department;
		this.qualification = qualification;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	@Override
	public String toString() {
		return "Professor [id=" + id + ", firstName=" + firstName + ", department=" + department + ", qualification="
				+ qualification + "]";
	}
	
}