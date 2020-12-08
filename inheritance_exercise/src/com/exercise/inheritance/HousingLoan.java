package com.exercise.inheritance;

public class HousingLoan extends Loan {

	private String propertyType;
	
	public HousingLoan() {
		
	}


	public HousingLoan(double loanAmount, double loanPeriod, int cibilScore, String propertyType) {
		super(loanAmount, loanPeriod, cibilScore);
		this.propertyType = propertyType;
	}


	@Override
	public double findRateOfInterest() {
		
		double interestRate = 0.0;
		double interestAmount = 0.0;
		
		interestRate = super.findRateOfInterest();
		
		interestAmount = ( getLoanAmount() * interestRate * getLoanPeriod())/100;
		
		return interestAmount;
	}	

}
