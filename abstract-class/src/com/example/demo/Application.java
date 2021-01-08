package com.example.demo;

import com.example.demo.model.BankAccount;
import com.example.demo.model.SavingsAccount;
import com.example.demo.model.BusinessAccount;

public class Application {

	public static void main(String[] args) {
		
		// superType = subType => always allowed
		
		System.out.println("Welcome");
		BankAccount account1 = new SavingsAccount(9833,"Ramesh",1000,"nalini");
		
		account1.deposit(1000000);
		account1.withdraw(2000);
		
		System.out.println("Current Balance :" + account1.getCurrentBalance());

		System.out.println("=====================================");
		
		BankAccount account2 = new BusinessAccount(9833,"Rakesh",1000,"rajesh");
		account2.deposit(50000);
		account2.withdraw(5000);
		
		System.out.println("Current Balance :" + account2.getCurrentBalance());
	}

}
