package com.training.utils;

import java.io.IOException;

public class ExceptionHandling {

	// using try/catch
	public static void usingTryCatch(String mark) {
		
		try {
			
			int markScored = Integer.parseInt(mark);
			System.out.println(markScored);
			
		} catch (NumberFormatException e) {
			
			System.err.println("Mark should be a positive integer - and not String");
			System.err.println(e.getMessage());
//			e.printStackTrace();
		}
		System.out.println("completed");
	}
	
	//  using finally
	public static void usingTryCatchFinally(String name) {
		
		try {
			
			int length = name.length();
			System.out.println("Length of given string is :" + length);
		} catch (NullPointerException e) {
			
			System.err.println("Argument name is Null");
			e.printStackTrace();
		} finally {
			System.out.println("Inside finally block");
		}
		System.out.println("completed");
	}
	
	// finally with return
	public static int usingTryCatchReturnFinally(String name) {

		int length = 0;
		try {
			length = name.length();
			System.out.println("Length of given string is :" + length);
		} catch (NullPointerException e) {
			
			System.err.println("Argument name is Null");
			e.printStackTrace();
			return 420;
		} finally {
			System.out.println("Inside finally block");
		}
		System.out.println("completed");
		return length;
	}
	
	// throws
	public static void usingThrowAndThrowsClause() throws IOException {
		
		int intChar = System.in.read();
		
		System.out.println(intChar);
	}
	
	// throw
	public static void usingThrow(){
		
		throw new RuntimeException("Hey");
	}
}
