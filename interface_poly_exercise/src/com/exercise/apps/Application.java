package com.exercise.apps;
import com.exercise.model.SoftwareEngineer;
import com.exercise.model.Advocate;
import com.exercise.services.BillService;
import com.exercise.model.Billable;

public class Application {
	
	// this method is a factory method which returns an instance of Billable
	public static Billable getProfessionObject(int key) {
		
		switch(key) {
		case 1: 
			return new SoftwareEngineer("Manager",101,"Rakesh");
		case 2:
			return new Advocate("High Court",201,"Ramesh");
		default:
			return null;
			
		}
	}

	public static void main(String[] args) {
		
		BillService service = new BillService();
		
		// Implementation using Factory Method(will produce objects)
		Billable obj = getProfessionObject(Integer.parseInt(args[0]));
		service.print(obj);
		
		// Implementation without using Factory Method
		SoftwareEngineer engg1 = new SoftwareEngineer("Manager",101,"Rakesh");
		service.print(engg1);
		SoftwareEngineer engg2 = new SoftwareEngineer("Manager",101,"Rajesh");
		service.print(engg2);
		Advocate advocate1 = new Advocate("High Court",201,"Ramesh");
		service.print(advocate1);
		Advocate advocate2 = new Advocate("Supreme Court",201,"Ramesh");
		service.print(advocate2);

	}

}
