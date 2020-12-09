package com.training;

import java.io.IOException;
import com.training.model.Student;
import com.training.utils.RangeCheckException;

import com.training.utils.ExceptionHandling;

public class Application {
	
	// declaring a name but not initializing
	static String name;

	public static void main(String[] args) {
		
		
		try {
			Student ram = new Student(101,"Ram",-1);
		} catch(RangeCheckException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		Student ramesh = new Student();
		ramesh.setMarkScored(110);
		
		

//		ExceptionHandling.usingTryCatch("sixtysix");

		
//		ExceptionHandling.usingTryCatchFinally(name);
		
//		int value = ExceptionHandling.usingTryCatchReturnFinally(name);
//		System.out.println("Length :" + value);
		
//		try {
//			ExceptionHandling.usingThrowAndThrowsClause();
//		} catch (IOException e) {
//			System.err.println("Using declare rule of exception handling");
//			e.printStackTrace();
//		}
		
		
//		try {
//			ExceptionHandling.usingThrow();
//		} catch(RuntimeException e) {
//			System.out.println("catched");
//		}
	}

}
