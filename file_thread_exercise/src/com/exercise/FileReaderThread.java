package com.exercise;
import java.io.File;

import com.exercise.services.*;

public class FileReaderThread implements Runnable{

	
	FileService service = new FileService();
	
	@Override
	public void run() {
         
		String str = service.readFromFile();
		if(str != null) {
			System.out.println(str);
		}
		else {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
}
