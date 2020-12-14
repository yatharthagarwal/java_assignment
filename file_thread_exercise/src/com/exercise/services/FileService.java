package com.exercise.services;

import java.io.*;

public class FileService {

	static File file = new File("Data_new.txt");
	public synchronized boolean writeToFile(String[] array) {
		
		try(PrintWriter writer = new PrintWriter(new FileWriter(file))) {
			for (String str : array) {
				writer.println(str);
			}
			Thread.sleep(5000);
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
   }
	
	public synchronized String readFromFile() {
		String line = null;
		String return_line = "";
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			while((line = reader.readLine())!=null) {
				return_line += line;
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		return return_line;
	}
}
