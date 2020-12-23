package com.example.demo.model;

public class BusinessAccount extends BankAccount {
	
	private String businessType;

	public BusinessAccount(long accountNumber, String accountHolderName, double currentBalance, String businessType) {
		super(accountNumber, accountHolderName, currentBalance);
		this.businessType = businessType;
	}
	
	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}



	@Override
	public double deposit(double amount) {

		if(amount <= 1000000) {
			double currentBalance = getCurrentBalance();
			double clearBalance = amount + currentBalance;
			setCurrentBalance(clearBalance);
		} else {
			System.out.println("Cannot Deposit more than 10 Lakh");
		}
		return 0;
	}

	@Override
	public double withdraw(double amount) {

		if(getCurrentBalance() - amount < 25000) {
			System.out.println("Cannot withdraw amount");
		} else {
			double currentBalance = getCurrentBalance();
			double clearBalance = currentBalance - amount;
			setCurrentBalance(clearBalance);
		}
		return 0;
	}

}
