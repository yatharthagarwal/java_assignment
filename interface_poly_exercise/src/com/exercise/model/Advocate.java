package com.exercise.model;

public class Advocate implements Billable {

	private String jobType;
	private int employeeId;
	private String advocateName;
	
	public Advocate(String jobType, int employeeId, String advocateName) {
		super();
		this.jobType = jobType;
		this.employeeId = employeeId;
		this.advocateName = advocateName;
	}

	@Override
	public double calculateSalary() {

		double salary = 0.0;
		if(this.jobType.equals("High Court")) {
			salary = 50000.00;
		} else if(this.jobType.equals("Supreme Court")) {
			salary = 60000.00;
		} else {
			salary = 0.0;
		}
		return salary;
	}

}
