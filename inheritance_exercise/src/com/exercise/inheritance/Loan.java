package com.exercise.inheritance;

public class Loan {
	
	private double loanAmount;
	private double loanPeriod;
	private int cibilScore;
	
	public Loan() {
		
	}
	
	public Loan(double loanAmount, double loanPeriod, int cibilScore) {
		super();
		this.loanAmount = loanAmount;
		this.loanPeriod = loanPeriod;
		this.cibilScore = cibilScore;
	}
	
	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getLoanPeriod() {
		return loanPeriod;
	}

	public void setLoanPeriod(double loanPeriod) {
		this.loanPeriod = loanPeriod;
	}

	public int getCibilScore() {
		return cibilScore;
	}

	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}
	
	public double findRateOfInterest() {
		double interestRate = 0;
		
		if(this.cibilScore > 500) {
			interestRate = 7.5;
		} else {
			interestRate = 8.2;
		}
		
		return interestRate;
	}

}
