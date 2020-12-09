package com.example.demo.services;

import java.io.*;
import com.example.demo.*;
import com.example.model.Professor;

public class ProfessorService {

	public boolean writeObjectToFile(Professor prof,File file) {
		
		boolean result = false;
		
		// using try with resource
		try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(file))) {
			outStream.writeObject(prof);
			result = true;
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean writeObjectToFile(Professor[] profs,File file) {
		
		boolean result = false;
		
		// using try with resource
		try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(file))) {
				outStream.writeObject(profs);
			result = true;
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Object readObjectFromFile(File file) {
		Object obj = null;
		
		try(ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(file))){
			obj = inStream.readObject();
			
			// catch multiple exception
		} catch(ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
}
