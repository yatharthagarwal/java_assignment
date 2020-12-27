package com.exercise.model;

public class SoftwareEngineer implements Billable {
	
	private String roleType;
	private int employeeId;
	private String employeeName;

	public SoftwareEngineer(String roleType, int employeeId, String employeeName) {
		super();
		this.roleType = roleType;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}

	@Override
	public double calculateSalary() {
		double salary = 0.0;
		
		if(this.roleType.equals("Tester")) {
			salary = 50000.00;
		} else if(this.roleType.equals("Manager")) {
			salary = 80000.00;
		} else if(this.roleType.equals("Architect")) {
			salary = 90000.00;
		} else {
			salary = 0.0;
		}
		return salary;
	}

}
