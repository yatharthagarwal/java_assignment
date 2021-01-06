package com.training.model;

import java.time.LocalDate;

public class BloodDonor {

	private String name;
	private int age;
	private String gender;
	private String bloodGroup;
	private int mobileNumber;
	private String email;
	private LocalDate dateOfBirth;
	
	public BloodDonor() {
		// TODO Auto-generated constructor stub
	}

	public BloodDonor(String name, int age, String gender, String bloodGroup, int mobileNumber, String email,
			LocalDate dateOfBirth) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "BloodDonor [name=" + name + ", age=" + age + ", gender=" + gender + ", bloodGroup=" + bloodGroup
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", dateOfBirth=" + dateOfBirth + "]";
	}
}
