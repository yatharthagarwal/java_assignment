package com.book.apps;
import java.util.Scanner;

import com.book.model.Book;
import com.book.service.BookService;

public class Application {

	public static void main(String[] args) {

		// Instance of Book
		Book firstBook = new Book(101,"The Jungle Book","Rudyard Kipling",200.00);
		
		BookService myService = new BookService();
		
		// Input
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter customer Type");
		String customerType = sc.next();
		
		double discount1 = myService.calculateDiscount(firstBook);
		System.out.println("Discount1 " + discount1);
		
		double discount2 = myService.calculateDiscount(firstBook,customerType);
		System.out.println("Discount2 " + discount2);
		
		double discount3 = myService.calculateDiscount(firstBook,customerType);
		System.out.println("Discount3 " + discount3);
		
		sc.close();
	}

}
