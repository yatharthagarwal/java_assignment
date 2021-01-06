package com.example.daos;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;
import java.time.LocalDate;

import com.training.utils.DbConnectionUtil;
import com.example.ifaces.DataAccess;
import com.training.entity.Doctor;
import static java.util.stream.Collectors.*;

public class DoctorDaoImpl implements DataAccess<Doctor> {

	private Connection con;
	
	public static final String ADDSQL ="insert into lumen_doctor values(?,?,?,?,?)";


	public DoctorDaoImpl() {
		super();
		con = DbConnectionUtil.getMySqlConnection();	
	}

	public DoctorDaoImpl(Connection con) {
		super();
		this.con = con;
	}
	
	public List<Doctor> getEntries(){
		
		String sql = "select * from lumen_doctor";
		
		List<Doctor> doctorList = new ArrayList<Doctor>();
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmeta = rs.getMetaData();
			System.out.println("Number of columns" + rsmeta.getColumnCount());
			
			System.out.println("Table name of column 1 " + rsmeta.getTableName(1));
			
			
			while(rs.next()) {
				int doctorId = rs.getInt("doctorId");
				String doctorName = rs.getString("doctorName");
				long mobileNumber = rs.getLong("mobileNumber");
				String specialization = rs.getString("specialization");
				LocalDate dateOfBirth = rs.getDate("dateOfBirth").toLocalDate();
			
			   Doctor doctor = new Doctor(doctorId,doctorName,mobileNumber,specialization,dateOfBirth);
			   
			   doctorList.add(doctor);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return doctorList;
	}

	@Override
	public int add(Doctor t) {
		
		String sql = "insert into lumen_doctor values(?,?,?,?,?)";
		int rowsAdded = 0;
		try(PreparedStatement pstmt = con.prepareStatement(ADDSQL)) {
			
			pstmt.setInt(1, t.getDoctorId());
			pstmt.setString(2, t.getDoctorName());
			pstmt.setLong(3, t.getMobileNumber());
			pstmt.setString(4, t.getSpecialization());
			pstmt.setDate(5, Date.valueOf(t.getDateOfBirth()));
			
			rowsAdded = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsAdded;
	}

	@Override
	public List<Doctor> findAll() {
		List<Doctor> list = getEntries();
		return list;
	}

	@Override
	public Doctor update(Doctor existing, Doctor update) {
		String sql = "update lumen_doctor set doctorName=? mobileNumber=? specialization=? dateOfBirth=? where doctorId=?";
		int rowsUpdated = 0;
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setString(1, update.getDoctorName());
			pstmt.setLong(2, update.getMobileNumber());
			pstmt.setString(3, update.getSpecialization());
			pstmt.setDate(4, Date.valueOf(update.getDateOfBirth()));
			pstmt.setInt(5, existing.getDoctorId());
			
			rowsUpdated = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		List<Doctor> list = getEntries();
		list = list.stream()
								.filter(element -> element.getDoctorId()== existing.getDoctorId())
								.collect(toList());
		return list.get(0);
		
	}

	@Override
	public int remove(int id) {
		String sql = "delete from lumen_doctor where doctorId=?";
		
		int rowsDeleted = 0;
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setInt(1, id);
			
			rowsDeleted = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsDeleted;
	}

	@Override
	public Doctor findBy(int id) {
		
		List<Doctor> list = getEntries();
		list = list.stream()
								.filter(element -> element.getDoctorId()==id)
								.collect(toList());
		return list.get(0);
	}

	@Override
	public int[] addInBatch(Doctor... list) {
		
		int[] rows = null;
		try(PreparedStatement pstmt = con.prepareStatement(ADDSQL)) {
	        con.setAutoCommit(false);
			for(Doctor eachDoctor : list) {
			
				
				pstmt.setInt(1, eachDoctor.getDoctorId());
				pstmt.setString(2, eachDoctor.getDoctorName());
				pstmt.setLong(3, eachDoctor.getMobileNumber());
				pstmt.setString(4, eachDoctor.getSpecialization());
				pstmt.setDate(5, Date.valueOf(eachDoctor.getDateOfBirth()));
				
				pstmt.addBatch();
				
			} 
			rows = pstmt.executeBatch();
			con.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	public void usingTransaction() {
		String sql1 = "insert into lumen_doctor(doctorId,doctorName) values(?,?)";
		String sql2 = "insert into lumen_doctor(doctorId,doctorName) values(?,?)";
		Savepoint p1 = null;
		try {
			con.setAutoCommit(false);
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			
			pstmt1.setInt(1, 201);
			pstmt1.setString(2, "dummy");
			
			pstmt1.executeUpdate();
			p1 = con.setSavepoint("point1");
			
			pstmt2.setInt(1, 202);
			pstmt2.setString(2, "munna");
			
			pstmt2.executeUpdate();
			con.commit();
			con.setAutoCommit(true);
		} catch(SQLException e) {
			e.printStackTrace();
			
			try {
				con.rollback(p1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
