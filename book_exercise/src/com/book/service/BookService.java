package com.book.service;

import com.book.model.Book;

public class BookService {

	// method taking book as argument
	public double calculateDiscount(Book myBook) {
		double discount = 0.00;
		
		if(myBook.getPrice() < 50) {
			discount = 0.05 * (myBook.getPrice());
		}
		else{
			discount = 0.10 * (myBook.getPrice());
		}
		
		return discount;
	}
	
	// Overloaded method taking book and customerType as argument
	public double calculateDiscount(Book myBook,String customerType) {
		double discount = 0.00;
		
		if(customerType.equals("corporate")) {
			if(myBook.getPrice() < 50) {
				discount = 0.05 * myBook.getPrice();
		   }
			else {
				discount = 0.15 * myBook.getPrice();
		   }
		}
		else{
			if(myBook.getPrice() < 50) {
				discount = 0.20 * myBook.getPrice();
			}
			else {
				discount = 0.30 * myBook.getPrice();
			}	
		}
		
		return discount;
	}
}
