package com.training.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.training.ifaces.Operations;
import com.training.model.Doctor;
import com.training.model.Patient;

public class DoctorService implements Operations<HashMap<Doctor,List<Patient>>,Doctor> {

	// Add doctor to the list
	@Override
	public void add(HashMap<Doctor,List<Patient>> appointmentList, Doctor doctor) {
		
		appointmentList.put(doctor,null);
	}

	// Get list of doctors
	@Override
	public List<Doctor> get(HashMap<Doctor,List<Patient>> appointmentList) {
		
		Set<Doctor> set = appointmentList.keySet();
		List<Doctor> list = new ArrayList(set);
		
		return list;
	}

}
