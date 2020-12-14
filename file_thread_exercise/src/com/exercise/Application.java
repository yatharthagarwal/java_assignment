package com.exercise;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
	
	public static void main(String[] args) {
		
		String[] values = {"yatharth","ram","shyam"};
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		FileWriterThread writer = new FileWriterThread(values);
		
		FileReaderThread reader = new FileReaderThread();

		executor.submit(writer);
		executor.submit(reader);
		
		executor.shutdown();
	}

}
