package com.training.model;

public class Doctor extends Person {

	private String doctorRole;                                    // Role of the doctor

	public Doctor() {
		
	}

	// Overloaded Constructor 3 fields
	public Doctor(String name, int age, String doctorRole) {              
		super(name, age);
		this.doctorRole = doctorRole;
	}

	public String getDoctorRole() {
		return doctorRole;
	}

	public void setDoctorRole(String doctorRole) {
		this.doctorRole = doctorRole;
	}

	@Override
	public String toString() {
		return "Doctor [doctorRole=" + doctorRole + ", Name=" + getName() + ", Age=" + getAge() + "]";
	}
	
	

}
