package com.project.apps;

import java.io.File;
import java.util.Scanner;

import com.project.services.ConsoleService;
import com.project.services.FileService;

public class Application {
	
	// To perform operations using files
	public static void fileOperations(int operationCode) {
		
		FileService fileService = new FileService();					  // instance of FileService
		FilePaths paths = new FilePaths();                                // instance of FilePaths
		File file = new File(paths.getFilePath().get(operationCode-1));   // get file corresponding to operation type
		int rows = 0;
		String result = null;
		
		// select required operation
		switch(operationCode) {
		case 1 : rows = fileService.addOrUpdateOrDelete(file,1);
				 break;
		case 2 : rows = fileService.addOrUpdateOrDelete(file, 2);
				 break;
		case 3 : result = fileService.generateReports(file, 1);
				 break;
		case 4 : result = fileService.generateReports(file, 2);
		 		 break;	
		case 5 : result = fileService.generateReports(file, 3);
				 break;
		case 6 : result = fileService.generateReports(file, 4);
		         break;	
		case 7 : result = fileService.generateReports(file, 5);
		 		 break;
		case 8 : rows= fileService.addOrUpdateOrDelete(file, 3);
		         break;  		 
		}
		
		// for add/update/delete "if" is true otherwise "else" is true
		if(operationCode==1 || operationCode==2 || operationCode==8) {
			System.out.println("Changes made = " + rows);
		} else {
			System.out.println("Result : " + result);
		}
	}

	// To perform operations using console
	public static void consoleOperations(int operationCode) {
		
		ConsoleService service = new ConsoleService();           // Instance of ConsoleService 
		int rows = 0;
		String result = null;
		
		//select required operation
		switch(operationCode) {
		case 1 : rows = service.addOrUpdate(1);
				 break;
		case 2 : rows = service.addOrUpdate(2);
				 break;
		case 3 : result  = service.generateReports(1);
				 break;
		case 4 : result = service.generateReports(2);
		 		 break;	
		case 5 : result = service.generateReports(3);
				 break;
		case 6 : result = service.generateReports(4);
		         break;	
		case 7 : result = service.generateReports(5);
		 		 break;	
		case 8 : rows = service.remove();
				 break;
		}
		
		// for add/update/delete "if" is true otherwise "else" is true
		if(operationCode==1 || operationCode==2 || operationCode==8) {
			System.out.println("Changes made = " + rows);
		} else {
			System.out.println("Result : " + result);
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean performOperations = true;          // to signal to perform operations
		
		int choice = 0;
		int operationCode = 0;
	
		// loop till "performOperations" becomes false 
		do {
			
			// Choose to perform operations with file or using console otherwise exit
			System.out.println("Press 1 to perform operations using File");
			System.out.println("Press 2 to perform operations using Console");
			System.out.println("Press 3 to exit");
			
			// input stored in "choice"
			choice = sc.nextInt();
			
			// if choice is not 1 or 2 than don't show the options
			if(choice < 3) {
				System.out.println("Press 1 to add contacts");
				System.out.println("Press 2 to update contacts");
				System.out.println("Press 3 to get birthday's in given month");
				System.out.println("Press 4 to get list of contacts in a group");
				System.out.println("Press 5 to get list of contacts with their name and e-mail");
				System.out.println("Press 6 to get list of contacts with their name and mobile Number");
				System.out.println("Press 7 to get information according to group length");
				System.out.println("Press 8 to delete data from table");
			
				// take input for the operation type
				operationCode = sc.nextInt();
			}
			
			
			switch(choice) {
			case 1 : fileOperations(operationCode);            // do operations using file
					 break;
			case 2 : consoleOperations(operationCode);         // do operations using console
					 break;
			default : performOperations = false;	           // exit from the loop
					  break;
			}
		}while(performOperations);	
			sc.close();                                        // close input stream
	}
	
}
