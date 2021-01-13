package com.project.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.time.LocalDate;

import com.project.ifaces.DataAccessObject;
import com.project.model.Contact;
import com.project.services.DaoImplementation;
import com.project.services.FileService;

import org.junit.jupiter.api.*;
import com.project.apps.FilePaths;

public class Testing {
	
	DataAccessObject<Contact> dao;
	FilePaths paths;
	
	@BeforeEach
	public void beforeEachTest() {
		dao = new DaoImplementation();
		paths = new FilePaths();
	}
	
	@Test
	@DisplayName(value="Test whether the contact can be added")
	void testAdd() {
		Contact contact = new Contact("test","test address",2546,"abc/image.jpg",LocalDate.parse("1478-05-07"),"test@gail.com","relatives");
		int rowsAdded = dao.add(contact);
		assertEquals(1, rowsAdded);
	}
	
	@Test
	@DisplayName(value="Test whether the contact can be updated")
	void testUpdate() {
		Contact contact = new Contact("testUpdate","test address",2546,"abcUpdate/image.jpg",LocalDate.parse("2020-11-12"),"test_update@gmail.com","relatives");
		int rowsUpdated = dao.update(contact);
		assertEquals(1, rowsUpdated);
	}
	
	@Test
	@DisplayName(value="Test whether the contact can be added using file")
	void testAddFromFile() {
		File file = new File(paths.getFilePath().get(0));
		FileService service = new FileService();
		int rowsAdded = service.addOrUpdateOrDelete(file, 1);
		assertNotNull(rowsAdded);;
	}
	
	@Test
	@DisplayName(value="Test whether the list can be displayed according to group size")
	void testOrderedList() {
		File file = new File(paths.getFilePath().get(6));
		FileService service = new FileService();
		String result = service.generateReports(file, 5);
		assertEquals("Done succesfully", result);
	}
	
	@Test
	@DisplayName(value="Delete rows using files")
	void deleteRowsFromFiles() {
		File file = new File(paths.getFilePath().get(7));
		FileService service = new FileService();
		int result = service.addOrUpdateOrDelete(file, 3);
		assertNotNull(result);
	}
}
