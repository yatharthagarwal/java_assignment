package com.project.model;

import java.time.LocalDate;

public class Contact {

	private String name;
	private String address;
	private int mobileNumber;
	private String imageReference;
	private LocalDate dateOfBirth;
	private String email;
	private String groupName;
	
	public Contact() {
		
	}

	public Contact(String name, String address, int mobileNumber, String imageReference, LocalDate dateOfBirth,
			String email, String groupName) {
		super();
		this.name = name;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.imageReference = imageReference;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.groupName = groupName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getImageReference() {
		return imageReference;
	}

	public void setImageReference(String imageReference) {
		this.imageReference = imageReference;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "[NAME = " + name + ", ADDRESS = " + address + ", MOBILE NUMBER = " + mobileNumber + ", IMAGE REFERENCE = "
				+ imageReference + ", DATE OF BIRTH = " + dateOfBirth + ", EMAIL = " + email + ", GROUP NAME = " + groupName + "]";
	}
	
	
}
