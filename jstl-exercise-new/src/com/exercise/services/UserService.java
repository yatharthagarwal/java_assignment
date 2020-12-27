package com.exercise.services;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import com.exercise.model.User;

public class UserService {
	
	List<User> list;
//	HashMap<>
	
	public UserService() {
		add();
	}
    
	
	private void add() {
		User user1 = new User("Ram",1200.00);
		User user2 = new User("Manish",1300.00);
		User user3 = new User("Rajesh",2300.00);
		User user4 = new User("Rakesh",4500.00);
		
		list = Arrays.asList(user1,user2,user3,user4);
	}
	
	public double amountDeduction(String name,String planType) {
		
		double amount = 0.0;
	    double cost = 0.0;
		
		if(planType.equals("ac500")) {
			cost = 500.00;
		} else if(planType.equals("ac1000")) {
			cost = 1000.00;
		} else {
			cost = 1500.00;
		}
		
		// change for loop  to do-while 
		boolean iterate = true;
		int idx = 0;
		do {
			if(idx < list.size()) {
				if(list.get(idx).getUsername().equalsIgnoreCase(name)) {
					if(list.get(idx).getCreditLimit() < cost) {
						amount = -1;
					} else {
						amount = list.get(idx).getCreditLimit() - cost;
						list.get(idx).setCreditLimit(amount);
					}
					iterate = false;
				}
			}
		}while(iterate);
		
//		for(User user : this.list) {
//			if(user.getUsername().equalsIgnoreCase(name)) {
//				if(user.getCreditLimit() < cost) {
//					amount = -1;
//				} else {
//					amount = user.getCreditLimit() - cost;
//					user.setCreditLimit(amount);
//				}
//				break;
//			}
//		}
		return amount;
	}
	
	public double getCreditLimit(String name) {
		double amount = 0.0;
		for(User user : this.list) {
			if(user.getUsername().equalsIgnoreCase(name)) {
				amount = user.getCreditLimit();
			}
		}
		return amount;
	}
	
}

