package com.training.services;


import com.training.model.User;

public class Validator {

	public Validator() {
		
	}

	
	public boolean validate(User user) {
		boolean result=false;
		if(user.getUserName().equals("india") && user.getPassword().equals("india")) {
			result = true;
		} 
		
		return result;
	}
}
