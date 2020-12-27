package com.project.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.*;

import com.project.ifaces.DataAccessObject;
import com.project.model.Contact;
import com.project.model.Group;
import com.project.util.DbConnection;

public class DaoImplementation implements DataAccessObject<Contact> {

	private Connection con;
	
	// Constructor to initialize the connection variable
	public DaoImplementation() {
		this.con = DbConnection.getMySqlConnection();
	}
	
	// To get list of all entries in the group_info table(Used to get groupId from groupName)
	private List<Group> getGroupEntries(){
		
		String sql = "select * from group_info";
		List<Group> list = new ArrayList<>();
		try(PreparedStatement pstmt = this.con.prepareStatement(sql)){
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int groupId = rs.getInt("groupId");
				String groupName = rs.getString("groupName");
				
				Group group = new Group(groupId,groupName);
				list.add(group);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	// Perform the sql operations given the sql string,operation code 
	private int sqlOperationsForAddAndUpdate(String sql, int operationCode, Contact contact) {
		
		// retrieves the list from the group_info table
		List<Group> list = getGroupEntries();
		
		// get the groupId from the groupName using streams api on list
		list = list.stream().filter(element -> element.getGroupName().equalsIgnoreCase(contact.getGroupName()))
															.collect(toList());
		int rows = 0;
		
		// Used preparedstatement to perform operations 
		try(PreparedStatement pstmt = this.con.prepareStatement(sql)){
			
			pstmt.setString(1, contact.getName());
			pstmt.setString(2, contact.getAddress());
			
			// to add rows in the table
			if(operationCode == 1) {
				pstmt.setInt(3, contact.getMobileNumber());
				pstmt.setString(4, contact.getImageReference());
				pstmt.setDate(5, Date.valueOf(contact.getDateOfBirth()));
				pstmt.setString(6, contact.getEmail());
				pstmt.setInt(7,list.get(0).getGroupId());
			} else {             
				// to update rows in the table
				pstmt.setString(3, contact.getImageReference());
				pstmt.setDate(4, Date.valueOf(contact.getDateOfBirth()));
				pstmt.setString(5, contact.getEmail());
				pstmt.setInt(6,list.get(0).getGroupId());
				pstmt.setInt(7, contact.getMobileNumber());
			}
			
			rows = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("Operation not done");
			e.printStackTrace();
		}
		
		return rows;
	}
	

	// Add the contacts to the database
	@Override
	public int add(Contact contact) {

		String sql = "insert into contact_info values(?,?,?,?,?,?,?)";
		int rowsAdded = sqlOperationsForAddAndUpdate(sql,1,contact);

		return rowsAdded;
	}


	@Override
	public List<Contact> findAll() {
		
		List<Contact> list = new ArrayList<>();
		String sql = "select * from contact_info";
		try(PreparedStatement pstmt = this.con.prepareStatement(sql)){
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				String address = rs.getString("address");
				int mobileNumber = rs.getInt("mobileNUmber");
				String imageReference = rs.getString("imageReference");
				LocalDate dateOfBirth = rs.getDate("dateOfBirth").toLocalDate();
				String email = rs.getString("email");
				int groupId = rs.getInt("groupId");
				
				List<Group> groupList = getGroupEntries();
				groupList = groupList.stream().filter(element -> element.getGroupId() == groupId)
						.collect(toList());
				
				Contact contact = new Contact(name,address,mobileNumber,imageReference,dateOfBirth,email,groupList.get(0).getGroupName());
				list.add(contact);
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int update(Contact contact) {

		String sql = "update contact_info set name=?,address=?,imageReference=?,dateOfBirth=?,email=?,groupId=? where mobileNumber=?";
		int rowsUpdated = sqlOperationsForAddAndUpdate(sql,2,contact);;

		return rowsUpdated;
	}

	@Override
	public int remove(int mobileNumber) {
		String sql = "delete from contact_info where mobileNumber=?";
		int rowsDeleted = 0;
		try(PreparedStatement pstmt = this.con.prepareStatement(sql)){
			pstmt.setInt(1, mobileNumber);
			rowsDeleted = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rowsDeleted;
	}
}
