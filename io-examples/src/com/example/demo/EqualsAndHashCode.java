package com.example.demo;
import com.example.model.Professor;

public class EqualsAndHashCode {

	public static void main(String[] args) {

		Professor suresh = new Professor(3838,"Suresh","ECe","phd");
		
		Professor otherSuresh = suresh;
		System.out.println("Is suresh and OtherSuresh Equal :" + suresh.equals(otherSuresh));
		
		Professor suresh2 = new Professor(3838,"Suresh","ECe","phd");
		
		System.out.println("Is suresh and suresh2 Equal :" + suresh.equals(suresh2));

	}

}
