package com.example.demo;

import com.example.demo.services.ProfessorService;
import java.io.*;
import com.example.model.*;

public class Application {

	public static void main(String[] args) {

		File file = new File("professor_new.ser");
		ProfessorService service = new ProfessorService();
		
		int key =2;
		if(key == 1) {
			Professor prof1 = new Professor(3838,"Suresh","ECE","phd"); 
			Professor prof2 = new Professor(3839,"ramesh","ECE","phd");
			Professor prof3 = new Professor(3840,"mukesh","ECE","phd");
			Professor prof4 = new Professor(3841,"rakesh","ECE","phd");
			
			Professor[] list = {prof1,prof2,prof3,prof4};
			
			boolean result = service.writeObjectToFile(list, file);
			
			if(result) {
				System.out.println("One Object Serialized");
			} else {
				System.out.println("Check - Exception");
			}
		}
		
		if(key==2) {
			Professor[] profs = (Professor[])service.readObjectFromFile(file);
			
			for(Professor prof : profs) {
				System.out.println("De-serialized :" + prof);
			}
		}
		
	}

}
