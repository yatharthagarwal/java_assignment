package com.training.daos;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//import com.mysql.jdbc.PreparedStatement;
import com.training.ifaces.DataAccess;
import com.training.model.BloodDonor;
import com.training.utils.DbConnectionUtil;

public class DaoImpl implements DataAccess<BloodDonor> {

	Connection con;
	public DaoImpl() {
		this.con = DbConnectionUtil.getMySqlConnection();
	}

	@Override
	public int add(BloodDonor donor) {
		
		String sql = "insert into donors values(?,?,?,?,?,?,?)";
		int rowAdded = 0;
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setString(1, donor.getName());
			pstmt.setInt(2, donor.getAge());
			pstmt.setString(3, donor.getGender());
			pstmt.setString(4, donor.getBloodGroup());
			pstmt.setLong(5, donor.getMobileNumber());
			pstmt.setString(6, donor.getEmail());
			pstmt.setDate(7, Date.valueOf(donor.getDateOfBirth()));
			
			rowAdded = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rowAdded;
	}

	@Override
	public List<BloodDonor> findAll() {
		String sql = "select * from donors";
		
		List<BloodDonor> list = new ArrayList<>();
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String bloodGroup = rs.getString("bloodGroup");
				int mobileNumber = rs.getInt("mobileNumber");
				String email = rs.getString("email");
				LocalDate date = rs.getDate("dateOfBirth").toLocalDate();
				
				BloodDonor donor = new BloodDonor(name,age,gender,bloodGroup,mobileNumber,email,date); 
				list.add(donor);
			}
		} catch(SQLException e) {
			
		}
		return list;
	}


}
