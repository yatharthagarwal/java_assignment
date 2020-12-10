package com.training;

import java.util.Collection;
import java.util.List;
import com.training.model.CreditCard;
import com.training.services.CreditCardService;
public class Application {

	public static void print(Collection<CreditCard> list) {
		for(CreditCard eachCard : list) {
			System.out.println(eachCard);
		}
	}
	
	public static void main(String[] args) {

		CreditCard card1 = new CreditCard(49494,"Rakesh",560000);
		CreditCard card2 = new CreditCard(458,"manish",5600);
		CreditCard card3 = new CreditCard(88,"ram",560088);
		CreditCard card4 = new CreditCard(555,"raj",56898);
		
		CreditCardService service = new CreditCardService();
		
//		System.out.println(service.add(card1));
//		System.out.println(service.add(card2));
//		System.out.println(service.add(card3));
//		System.out.println(service.add(card4));
		
		card1.setTransaction(1,"shopping",213);
		card1.setTransaction(1,"shopping",213);
		card1.setTransaction(2,"shopping",417);
		System.out.println(card1.getCardHolderName() + card1.getTransaction());
		
		card2.setTransaction(1,"shopping",213);
		card2.setTransaction(2,"shopping",417);
		System.out.println(card2.getCardHolderName() + card2.getTransaction());

		System.out.println(service.add(card1,card2,card3,card4));
		List<CreditCard> list1 = service.findAll();
		print(list1);
		
		List<CreditCard> list2 = service.sortedList("creditLimit");
		int listSize = list2.size();
		
		System.out.println("First 3 Credit Limit in ascending order");
		for(int i=0; i < 3 ;i++) {
			System.out.println(list2.get(i));
		}
		
		System.out.println("First 3 Credit Limit in Descending order");
		for(int i = (listSize-1); i >= (listSize - 3) ;i--) {
			System.out.println(list2.get(i));
		}
		
//		System.out.println("Soted by name");
//		List<CreditCard> sortedByName = service.sortedList("cardHolderName");
//		
//		print(sortedByName);
//		
//		System.out.println("Soted by card number");
//		List<CreditCard> sortedByNumber = service.sortedList("cardNumber");
//		
//		print(sortedByNumber);
	}

}
