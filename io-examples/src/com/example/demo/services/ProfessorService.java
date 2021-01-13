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
	
	public boolean writeToTextFile(Professor prof,File file) {
		boolean result = false;
		
		try(PrintWriter writer = new PrintWriter(new FileWriter(file,true))){
			writer.println(prof);
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Professor[] readFromTextFile(File file) {
		Professor[] list = new Professor[4];
		Professor[] newList = list;
		String line = null;
		int i=0;
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			while((line = reader.readLine())!=null) {
				String[] values = line.split(",");
				Professor prof = new Professor(Integer.parseInt(values[0]),values[1],values[2],values[3]);
				if(i == list.length) {
					System.arraycopy(list, 0, newList, 0, list.length);
					list = new Professor[list.length + 3]; 
					System.arraycopy(newList, 0, list, 0, newList.length);
					newList = list;
				} 
				list[i] = prof;
				i++;
				
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
