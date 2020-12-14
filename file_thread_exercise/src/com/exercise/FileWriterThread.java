package com.exercise;
import java.io.File;

import com.exercise.services.*;


public class FileWriterThread implements Runnable{

	private String[] array;
	
	FileService service = new FileService();
	
	public FileWriterThread(String[] array) {
		this.array = array;
	}
	
	@Override
	public void run() {
		
		if(service.writeToFile(this.array)) {
			this.notifyAll();
		} else {
			System.out.println("Some exception occured");
		}
	}

}
