package com.exercise.services;
import com.exercise.model.Billable;

public class BillService {

	public void print(Billable bill) {
		
		System.out.println(bill.calculateSalary());
	}
}
