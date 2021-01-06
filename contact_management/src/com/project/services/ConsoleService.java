package com.project.services;

import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.project.model.Contact;
import com.project.ifaces.DataAccessObject;

public class ConsoleService {

	DataAccessObject<Contact> dao = null;
	Scanner sc = new Scanner(System.in);

	// Initialize DaoImplementation 
	public ConsoleService() {
		this.dao = new DaoImplementation();
	}
	
	// To perform Add/Update operations
	public int addOrUpdate(int operationCode) {
		System.out.println("Enter Name :");
		String name = sc.next();
		System.out.println("Enter Address :");
		String address = sc.next();
		System.out.println("Enter Mobile Number");
		int mobileNumber = sc.nextInt();
		System.out.println("Enter Image Reference");
		String imageReference = sc.next();
		System.out.println("Enter Date of Birth");
		String dateOfBirth = sc.next();
		System.out.println("Enter E-mail");
		String email = sc.next();
		System.out.println("Enter Group Name");
		sc.nextLine();
		String groupName = sc.nextLine();
		System.out.println(groupName);
		
		// create an instance of contact from the values provided by the user 
		Contact contact = new Contact(name,address,mobileNumber,imageReference,LocalDate.parse(dateOfBirth),email,groupName);
		int rows = 0;
		
		// perform add/update based on user input
		if(operationCode == 1) {
			rows = this.dao.add(contact);
		} else {
			rows = this.dao.update(contact);
		}
		
		
		return rows;
	}
	
	// To remove rows from the dbms
	public int remove() {
		System.out.println("Enter Mobile Number");
		int mobileNumber = sc.nextInt();
		int rows = this.dao.remove(mobileNumber);
		return rows;
	}
	
	// Generate reports corresponding to user input 
	// Streams api is used
	public String generateReports(int operationCode) {
		
		// Retrieve the contact_info table from the database and store as a list
		List<Contact> list = this.dao.findAll();
		boolean isDone = false;
		
		switch(operationCode) {
		
		// Retrieve birthday list of a specific month
		case 1 :  System.out.println("Enter Month");
				  String month = sc.next();
				  List<LocalDate> birthdayList = list.stream().filter((element) -> element.getDateOfBirth().getMonth().toString().equalsIgnoreCase(month))
						  				.map(element -> element.getDateOfBirth())
						  						.collect(toList());
				  System.out.println(birthdayList);
				  isDone = true;
				  break;
				  
		// Retrieve contact information specific to the group name given by user		  
		case 2 : System.out.println("Enter group name");
				 String groupName = sc.nextLine();
				 List<Contact> contacts = list.stream().filter(element -> element.getGroupName().equalsIgnoreCase(groupName))
						 								.collect(toList());
				 for (Contact contact : contacts) {
					 System.out.println(contact);
				 }
				 isDone = true;
				 break;
				 
		// Retrieve email list from dbms		 
		case 3 : List<String> emailList = list.stream().map(element -> "Name :" + element.getName() + " ,Email :" + element.getEmail())
															.collect(toList());		 
				 for (String entry : emailList) {
					System.out.println(entry);
				 }
				 isDone = true;
		         break;
		         
		 // Retrieve mobile list from dbms        
		case 4 : List<String> mobileList = list.stream().map(element -> "Name :" + element.getName() + " ,Mobile Number :" + element.getMobileNumber())
															.collect(toList());		 
				 for (String entry : mobileList) {
					 System.out.println(entry);
				 }
				 break; 
				 
		// To get list of people sorted in ascending order of their group size			 
		case 5 : long relativesCount	= list.stream().filter(element -> element.getGroupName().equalsIgnoreCase("relatives")).count();
				 long personalCount	= list.stream().filter(element -> element.getGroupName().equalsIgnoreCase("personal friends")).count();
				 long professionalCount = list.stream().filter(element -> element.getGroupName().equalsIgnoreCase("professional friends")).count();
				 
				 // put count of each group in a map  
				 Map<String,Long> countMap = new HashMap<>();
				 
				 countMap.put("relatives",relativesCount);
				 countMap.put("personal friends",personalCount);
				 countMap.put("professional friends",professionalCount);
				 
				 // store the map as an entryset in the list
				 List<Map.Entry<String, Long>> setList = new ArrayList<>(countMap.entrySet());
				 
				 // sort the list using values(group size) - comparator is used
				 Collections.sort(setList, new Comparator<Map.Entry<String,Long>>(){
					 
					 public int compare( Map.Entry<String,Long> o1, Map.Entry<String,Long> o2) {
						 int result = 0;
						 if (o1.getValue() < o2.getValue()) {
							 result = 1;
						 } else {
							 result = -1;
						 }
						 return result;
					 }
				 });
				 
				 // Store entries in "temp" group wise 
				 List<String> temp = new ArrayList<>();
				 
				 // Iterate through the list based on group size 
				 for(Map.Entry<String,Long> entry : setList) {
					 
					 System.out.println("Group Name :" + entry.getKey() + ", Number of contacts :" + entry.getValue());
					 
					 // Store list corresponding to a particular group in "temp"
					 temp = list.stream().filter(element -> element.getGroupName().equalsIgnoreCase(entry.getKey()))
							 												.map(element -> "Name :" + element.getName() + " , Mobile :" + element.getMobileNumber())
							 												.collect(toList());
					 for(String value : temp) {
						 System.out.println(value);;
					 }
				 }
				 
				 isDone = true;
				 break;  	 
		}
		
		// To show if operation is done successfully
		String result = null;
		if(isDone) {
			result = "Done succesfully";
		} else {
			result = "Unsuccessfull";
		}
		
		return result;
	}
	
	
}
