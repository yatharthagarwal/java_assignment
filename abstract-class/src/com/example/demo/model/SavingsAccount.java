package com.example.demo.model;

public class SavingsAccount extends BankAccount {
	
	private String nominee;
	

	public SavingsAccount(long accountNumber, String accountHolderName, double currentBalance, String nominee) {
		super(accountNumber, accountHolderName, currentBalance);
		this.nominee = nominee;
	}

	@Override
	public double deposit(double amount) {

		if(amount <= 100000) {
			double currentBalance = getCurrentBalance();
			double clearBalance = currentBalance + amount;
			setCurrentBalance(clearBalance);
		} else {
			System.out.println("Cannot Deposit more than 1 Lakh");
		}
		return 0;
	}

	@Override
	public double withdraw(double amount) {
		
		if(getCurrentBalance() - amount < 5000) {
			System.out.println("Cannot withdraw amount");
		} else {
			double currentBalance = getCurrentBalance();
			double clearBalance = currentBalance - amount;
			setCurrentBalance(clearBalance);
		}
		return 0;
	}

	public String getNominee() {
		return nominee;
	}

	public void setNominee(String nominee) {
		this.nominee = nominee;
	}
	
	

}
