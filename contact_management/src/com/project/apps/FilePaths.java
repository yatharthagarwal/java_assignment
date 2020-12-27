package com.project.apps;

import java.util.ArrayList;
import java.util.List;

public class FilePaths {
	
	List<String> paths;

	// constructor to initialize the FilePaths instance
	public FilePaths() {
		this.paths = new ArrayList<>();
		
		//  Add file paths to the list "paths"
		this.addFilePaths();
	}
	
	// Add list of all paths
	private void addFilePaths() {
		this.paths.add("inputFiles/Input_Data.txt");
		this.paths.add("inputFiles/Update_Data.txt");
		this.paths.add("outputFiles/birthdayList.txt");
		this.paths.add("outputFiles/contactList.txt");
		this.paths.add("outputFiles/emailList.txt");
		this.paths.add("outputFiles/mobileList.txt");
		this.paths.add("outputFiles/orderedContactList.txt");
		this.paths.add("inputFiles/Delete_Data.txt");
	}
	
	// return the file path corresponding to a particular operation
	public List<String> getFilePath(){
		return this.paths;
	}
}
