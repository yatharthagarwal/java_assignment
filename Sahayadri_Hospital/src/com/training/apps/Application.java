package com.training.apps;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import com.training.model.Doctor;
import com.training.model.Patient;
import com.training.model.Person;
import com.training.services.DoctorService;
import com.training.services.PatientService;

public class Application {
	
	public static LocalDate setAndGetDate() {
		int year = 0;
		int month = 0;
		int dayOfMonth = 0;
		Scanner sc = new Scanner(System.in);
			System.out.println("Enter year");
	        year = sc.nextInt();
	        System.out.println("Enter month");  
	     	month = sc.nextInt();
	     	System.out.println("Enter day of the month");  
	        dayOfMonth = sc.nextInt();
	        
        return LocalDate.of(year, month, dayOfMonth);
	}

	public static void main(String[] args) {
		
		
		HashMap<Doctor,List<Patient>> appointmentList = new HashMap<>();
		
		int key = 0;
		int age = 0;
		String name = "";
		String description = "";
		String doctorName = "";
//		String date = "";    //String date
		 LocalDate date;
		boolean iterator = true;
		
		DoctorService doctor = new DoctorService();
		
		while(iterator) {
			
			System.out.println("--------------------------------------------------------------------------------");
			
			System.out.println("Enter 1 to add Doctor\nEnter 2 to add Patient\nEnter 3 to show Patients of a Doctor\n Enter 4 to cancel appointment of a doctor");
			System.out.println("Enter 5 to show list of Doctors\n");
			Scanner sc = new Scanner(System.in);
			key = sc.nextInt();
			
			
			switch(key) {
			case 1 : System.out.println("Enter doctor name");
						name = sc.next();
					 System.out.println("Enter doctor age");	
					    age = sc.nextInt();
					 System.out.println("Enter doctor role");  
					    String role = sc.next();
					 doctor.add(appointmentList,new Doctor(name,age,role));   
					 break;
			case 2 : System.out.println("Enter patient name");
						name = sc.next();
					 System.out.println("Enter patient age");	
					 	age = sc.nextInt();
		             System.out.println("Enter patient description");  
		             	description = sc.next();
		             System.out.println("Enter doctor name to take appointment");  
		             	doctorName = sc.next();
		             System.out.println("Enter appointment date");  
		             	try {
		             		date = setAndGetDate();
		             		 PatientService patient = new PatientService(doctorName);
				             patient.add(appointmentList, new Patient(name,age,description,date));
		             	} catch (DateTimeException e){
		             		System.out.println("Please enter correct date values");
		             		e.printStackTrace();
		             	}
		             break;	
			case 3 :  System.out.println("Enter doctor name");
			          	doctorName = sc.next();
			          System.out.println("Enter date");
			          try {
			        	  date = setAndGetDate();
				          PatientService showPatient = new PatientService(doctorName,date);
				          List<Patient> patientList = showPatient.get(appointmentList);
				          for(Patient iteratePatient : patientList) {
				        	  System.out.println(iteratePatient);
				          }
			          } catch (DateTimeException e) {
			        	  System.out.println("Please enter correct date values");
		             	  e.printStackTrace();
			          }
			          break;
			case 4 :  System.out.println("Enter patient name");
						name = sc.next();
					  System.out.println("Enter doctor name");
	          			doctorName = sc.next(); 
	          		  System.out.println("Enter date");
	          		  try {
	          			  date = setAndGetDate();	
		          		  PatientService deletePatient = new PatientService(doctorName,date);	
		          		  deletePatient.delete(appointmentList, name);	
	          		  } catch (DateTimeException e) {
	          			System.out.println("Please enter correct date values");
		             	  e.printStackTrace();
	          		  }
	          		  break;
			case 5 : List<Doctor> list = doctor.get(appointmentList);  
						for(Doctor doctor1 : list) {
							System.out.println(doctor1);
						}
					 break;	
			default: iterator = false;
						break;
			}
			System.out.println("--------------------------------------------------------------------------------");
		}
	}
}
