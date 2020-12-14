package com.training.model;

import com.training.utils.RangeCheckException;

public class Student {
	
	private int rollNumber;
	private String studentName;
	private double markScored;
	

	public Student() {
		// TODO Auto-generated constructor stub
	}


	public Student(int rollNumber, String studentName, double markScored) throws RangeCheckException{
		super();
		this.rollNumber = rollNumber;
		this.studentName = studentName;
		if(markScored >=0 && markScored <=100) {
			this.markScored = markScored;
		} else {
			throw new RangeCheckException("marks should be between 0 and 100");
		}
		
	}


	public int getRollNumber() {
		return rollNumber;
	}


	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public double getMarkScored() {
		return markScored;
	}


	public void setMarkScored(double markScored) {
		
		try {
			
			if(markScored >= 0 && markScored <=100) {
				this.markScored = markScored;
			} else {
				throw new RangeCheckException("marks should be between 0 and 100");
			}
			
		} catch (RangeCheckException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}


	@Override
	public String toString() {
		return this.rollNumber + " : " + this.studentName + " : " + this.markScored;
	}
	
	
	

}
