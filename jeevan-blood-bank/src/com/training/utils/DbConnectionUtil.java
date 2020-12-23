package com.training.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import java.io.*;

public class DbConnectionUtil {

	
	private static List<String> get(){
		
		Connection con = null;
		List<String> list = new ArrayList<>(); 
		String fileName = "DbConnection.properties";
		
		try {
			InputStream inStream = DbConnectionUtil.class.getClassLoader()
										.getResourceAsStream(fileName);
		
			Properties props = new Properties();
			
			props.load(inStream);
			
//			Class.forName(props.getProperty("datasource.driverclass"));
					list.add(props.getProperty("datasource.url"));
					list.add(props.getProperty("datasource.username"));
					list.add(props.getProperty("datasource.password"));
		} catch(Exception e) {
				e.printStackTrace();
				
		}
		System.out.println("getting");
	return list;
	}
	
	public static Connection getMySqlConnection() {
		
		Connection con = null;
		
		String fileName = "DbConnection.properties";
		
		try {
//			InputStream inStream = DbConnectionUtil.class.getClassLoader()
//										.getResourceAsStream(fileName);
//		
//			Properties props = new Properties();
//			
//			props.load(inStream);
			
			List<String> list = get();
			
//			Class.forName(props.getProperty("datasource.driverclass"));
//			con = DriverManager.getConnection(
//												props.getProperty("datasource.url"),
//												props.getProperty("datasource.username"),
//												props.getProperty("datasource.password"));
			
			con = DriverManager.getConnection(list.get(0),list.get(1),list.get(2));
		} catch(Exception e) {
				e.printStackTrace();
				
		}
		
		return con;
	}
	
	public static RowSet getCachedRowSet() {
		
		CachedRowSet rowSet = null;
		RowSetFactory fact = null;
		
		try {
			fact = RowSetProvider.newFactory();
			rowSet = fact.createCachedRowSet();
//			String fileName = "DbConnection.properties";
//			InputStream inStream = DbConnectionUtil.class.getClassLoader()
//					.getResourceAsStream(fileName);
//
//			Properties props = new Properties();
//
//			props.load(inStream);
			
			List<String> list = get();
			
//			rowSet.setUrl(props.getProperty("datasource.url"));
//			rowSet.setUsername(props.getProperty("datasource.username"));
//			rowSet.setPassword(props.getProperty("datasource.password"));
			
			rowSet.setUrl(list.get(0));
			rowSet.setUsername(list.get(1));
			rowSet.setPassword(list.get(2));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rowSet;
	}
}
