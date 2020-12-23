package com.exercise.inheritance.apps;

import com.exercise.inheritance.HousingLoan;

public class Application {

	public static void main(String[] args) {

		HousingLoan loan1 = new HousingLoan(100000.00,4.5,200,"2 BHK Flat");
		
		double interestAmount1 = loan1.findRateOfInterest();
		System.out.println(interestAmount1);
		
		HousingLoan loan2 = new HousingLoan(100000.00,4.5,600,"1 BHK Flat");
		
		double interestAmount2 = loan2.findRateOfInterest();
		System.out.println(interestAmount2);

	}

}
