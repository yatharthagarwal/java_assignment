package com.exercise;

public class Bill {

	// Instance Variable
	private String customerName;
	private long mobileNumber;
	private double amount;
	
	//Class Variable
	public static String planName="Prepaid";

	public Bill() {
		
	}

	// Overloaded constructor // 3 param
	public Bill(String customerName, long mobileNumber, double amount) {
		super();
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.amount = amount;
	}

	//  Overloaded constructor // 2 param
	public Bill(String customerName, long mobileNumber) {
		this(customerName,mobileNumber,223.00);
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
	}

	public String getCustomerName() {
		return customerName;
	}
	
	public long getMobileNumber() {
		return mobileNumber;
	}

	public double getAmount() {
		return amount;
	}

}
