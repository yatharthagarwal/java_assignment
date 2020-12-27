package com.training.services;

import java.time.LocalDate;
import java.util.*;

import com.training.ifaces.Operations;
import com.training.model.Doctor;
import com.training.model.Patient;

public class PatientService implements Operations<HashMap<Doctor,List<Patient>>,Patient> {

	private String doctorName;               // Doctor name to retrieve list of patients and to cancel the appointment 
//	private String date;
	LocalDate date;                          // this.date is used to retrieve patient for a particular date and delete a patient 
	
	
	public PatientService() {
		
	}
	
	// This overloaded constructor used to add patient to a doctor
	public PatientService(String doctorName) {
		super();
		this.doctorName = doctorName;
	}

//	public PatientService(String doctorName,String date) {
//		super();
//		this.doctorName = doctorName;
//		this.date = date;
//	}
	

	// This overloaded constructor is used to delete and retrieve a patient
	public PatientService(String doctorName, LocalDate date) {
	super();
	this.doctorName = doctorName;
	this.date = date;
	}

	// Overriden method from interface to add patient to the list 
	@Override
	public void add(HashMap<Doctor, List<Patient>> appointmentList, Patient patient) {
		Set<Doctor> setView = appointmentList.keySet();                          // Store doctor's list as a set
		 boolean isAvailable = false;                                            // Doctor is available or not
		 for(Doctor entry : setView) {                                           // iterate through each doctor in the set
        	 if(entry.getName().equals(this.doctorName)) {                       // if found than add patient to the list
        		 List<Patient> oldList = appointmentList.get(entry);             // get old list of the patients for that doctor
        		 if(oldList == null) {                                           // if no patients added than add the first patient
        			 List<Patient> list = Arrays.asList(patient);
        			 appointmentList.put(entry,list);
        		 } else {
        			 boolean isPatientAvailable = false;           
        			 for(Patient patient1 : oldList) {               // Check whether patient is already registered
        				 if(patient.equals(patient1)) {              // (To check if patient is already available) equals() is overriden in Patient and person class
        					 isPatientAvailable = true;              // if available set "isPatientAvailable" to true
        					 break;
        				 }
        			 }
        			 if(!isPatientAvailable) {                             // if not available than add to the list 
        				 oldList = new ArrayList(oldList);                 // oldList is of fixed-size. To make is modifiable use "new ArrayList"  
            			 oldList.add(patient); 
    		             appointmentList.put(entry,oldList);               // update the list after adding the patient
        			 } else {
        				 System.out.println("Patient is already registered");
        			 }
        		 }
        		 isAvailable = true;                                          
        		 break;
        	 }
         }
        	 if(!isAvailable) {                                           // if doctor is not available
            		 System.out.println("Doctor is not available");
        	 }	
	}

	// Overriden method of interface (Get list of patients for a particular date)
	@Override
	public List<Patient> get(HashMap<Doctor,List<Patient>> appointmentList) {
		List<Patient> list = new ArrayList<>();                                         // create a new array list
		Set<Map.Entry<Doctor,List<Patient>>> setView1 = appointmentList.entrySet();     // convert array list into a set
        for(Map.Entry<Doctor, List<Patient>> entry : setView1) {
          	 if(entry.getKey().getName().equals(doctorName)) {                          // if doctor is present  
          		 for(Patient patient : entry.getValue()) {                              // Than iterate through the list of patients for a particular date
          			 	 if(patient.getDate().equals(this.date)) {
          			 		list.add(patient);
          			 	 }
          		 }
          	 }
           }
		return list;                                                                       // than add the patient to the list
	} 
	
	public void delete(HashMap<Doctor,List<Patient>> appointmentList,String patientName) {
		Set<Doctor> setView = appointmentList.keySet();                                     // convert doctor's list into set
		for(Doctor doctor : setView) {                                                      // iterate through the set of doctors
			if(doctor.getName().equals(this.doctorName)) {                                  // if doctor found
				List<Patient> list = appointmentList.get(doctor);                           // get list of patients for that doctor
				for(Patient patient : list) {                                                            // iterate through the patient list
					if(patient.getName().equals(patientName) && patient.getDate().equals(this.date)) {                // if found
						list = new ArrayList(list);                                                               // create new array list
						list.remove(patient);                                                                   // remove patient    
						appointmentList.put(doctor, list);                                                      // put modified list to that doctor
					}
				}
			}
		}
	}
}
