package com.exercise;

public class Application {

	public static void main(String[] args) {


		Bill ram = new Bill("Ram",4587985632L);
		
		System.out.println(ram.getAmount());
		System.out.println(ram.getCustomerName());
		System.out.println(ram.getMobileNumber());
		
		System.out.println(Bill.planName);
		
		Bill yatharth = new Bill("yatharth",5645864789L,234.00);
		
		System.out.println(yatharth.getAmount());
		System.out.println(yatharth.getCustomerName());
		System.out.println(yatharth.getMobileNumber());
		
		System.out.println(Bill.planName);

	}

}
