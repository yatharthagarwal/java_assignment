package com.project.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static java.util.stream.Collectors.*;

import com.project.ifaces.DataAccessObject;
import com.project.model.Contact;

public class FileService {

	DataAccessObject<Contact> dao = null;   
	Scanner sc = new Scanner(System.in);
	
	// Initialize DaoImplementation 
	public FileService() {
		this.dao = new DaoImplementation();
	}
	
	// Write to the file
	// This is a generic method
	private <T> boolean writeToFile(List<T> list,File file) {
		boolean isDone = false;
		try(PrintWriter writer = new PrintWriter(new FileWriter(file))){
			
			for(T eachElement : list) {
				writer.println(eachElement);
			}
			isDone = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// return variable to show if operation is done successfully
		return isDone;
	}
	
	// To perform Add/Update/Delete
	public int addOrUpdateOrDelete(File file,int opeationCode) {

		int rows = 0;
		
		// try-catch block with resource
		try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
			
			// Store each line from the file
			String line = null;
				while((line=reader.readLine()) != null) {
					
					// Store values from csv file in string array
					String[] values = line.split(",");
					switch(opeationCode){
					
						// Add to the dbms(passed contact as argument)
						case 1 : Contact contact = new Contact(values[0],values[1],Integer.parseInt(values[2]),values[3],LocalDate.parse(values[4]),values[5],values[6]);
								 rows += this.dao.add(contact);
								 break;
						
						// Update dbms (passed contact as argument)		 
						case 2 : Contact contact1 = new Contact(values[0],values[1],Integer.parseInt(values[2]),values[3],LocalDate.parse(values[4]),values[5],values[6]);
								 rows += this.dao.update(contact1);
								 break;
								 
						// Remove entry from database(passed mobile number of the person)		 
						case 3 : rows = this.dao.remove(Integer.parseInt(line.trim()));
								 break;
					}
					
			}
		} catch (IOException e) {
			System.out.println("Cannot perform Input/Output operations");
			e.printStackTrace();
		}
		
		// return rows affected by the operation
		return rows;
	}
	
	// Generate reports corresponding to operation code in the file passed into arguments 
	public String generateReports(File file, int operationCode) {
		
		// Retrieve all records from dbms to perform filter/map operations using streams
		// Streams allow operations on data without accessing the dbms each time 
		List<Contact> list = this.dao.findAll();
		boolean isDone = false;
		
		switch(operationCode) {
		
		// To get list of birthday's in current month
		case 1 :  System.out.println("Enter Month");
				  String month = sc.next();
				  List<LocalDate> birthdayList = list.stream().filter((element) -> element.getDateOfBirth().getMonth().toString().equalsIgnoreCase(month))
						  				.map(element -> element.getDateOfBirth())
						  						.collect(toList());
				  isDone = writeToFile(birthdayList,file);
				  break;
		
		// To get list of contacts in a specific group		  
		case 2 : System.out.println("Enter group name");
				 String groupName = sc.nextLine();
				 List<Contact> contacts = list.stream().filter(element -> element.getGroupName().equalsIgnoreCase(groupName))
						 								.collect(toList());
				 isDone = writeToFile(contacts,file);
				 break;
				 
		// To get name and email of a person in list 		 
		case 3 : List<String> emailList = list.stream().map(element -> "Name :" + element.getName() + " ,Email :" + element.getEmail())
															.collect(toList());		 
				 isDone = writeToFile(emailList,file);
		         break;
		         
		// To get name and mobile number of a person in list         
		case 4 : List<String> mobileList = list.stream().map(element -> "Name :" + element.getName() + " ,Mobile Number :" + element.getMobileNumber())
															.collect(toList());		 
				 isDone = writeToFile(mobileList,file);
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
				 
				 // Store entries to store in files in "newList" 
				 List<String> newList = new ArrayList<>();
				 
				 // Store entries in "temp" group wise 
				 List<String> temp = new ArrayList<>();
				 
				 // Iterate through the list based on group size
				 for(Map.Entry<String,Long> entry : setList) {
					 
					 // Add group name and size to "newList"
					 newList.add("Group Name :" + entry.getKey() + ", Number of contacts :" + entry.getValue());
					 
					 // Store list corresponding to a particular group in "temp"
					 temp = list.stream().filter(element -> element.getGroupName().equalsIgnoreCase(entry.getKey()))
							 												.map(element -> "Name :" + element.getName() + " , Mobile :" + element.getMobileNumber())
							 												.collect(toList());
					 
					 // Add entry to the "newList"
					 for(String value : temp) {
						 newList.add(value);
					 }
				 }
				 
				 // Write list to the file
				 isDone = writeToFile(newList,file);
				 break;  	 
		}
		
		String result = null;
		
		// To show if operation is done successfully
		if(isDone) {
			result = "Done succesfully";
		} else {
			result = "Unsuccessfull";
		}
		
		return result;
	}
}
