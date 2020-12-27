package com.training.model;

import java.time.LocalDate;

public class Patient extends Person {
	
	private String description;                                        // Description of the patient
//	private String date;
	private LocalDate date;                                            // Date of the appointment for the patient

	public Patient() {
		
	}
	
	
	// Implemented date using "String"
//	public Patient(String name, int age,String description,String date) {
//		super(name, age);
//		this.description = description;
//		this.date = date; 
//	}
	
	// Implemented date using java.time.LocalDate(Overloaded constructor using 3 fields)
	public Patient(String name, int age, String description, LocalDate date) {
		super(name, age);
		this.description = description;
		this.date = date;
	}

	
    // Getter/Setter methods for String type date 
//	public String getDate() {
//		return date;
//	}
//
//	public void setDate(String date) {
//		this.date = date;
//	}

	// Getter/Setter method for LocalDate type date
	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}

	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	// To compare inherited class objects according to the fields
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	

	@Override
	public String toString() {
		return "Patient [Description=" + description + ", Date=" + date + ", Name=" + getName() + ", Age="
				+ getAge() + " ] ";
	}
	
	

	
}
