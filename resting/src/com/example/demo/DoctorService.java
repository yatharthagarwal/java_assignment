package com.example.demo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.daos.DoctorDaoImpl;
import com.training.entity.Doctor;

@Path("/doctors")
public class DoctorService{
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctor() {
		DoctorDaoImpl dao = new DoctorDaoImpl();
		List<Doctor> list = dao.findAll();
		
		return Response.status(200).entity(list).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setDoctor(Doctor doctor) {
		DoctorDaoImpl dao = new DoctorDaoImpl();
		int rowsAdded = dao.add(doctor);
		if(rowsAdded == 1) {
			return Response.status(201).entity(doctor).build();
		} else {
			return Response.status(111).entity(doctor).build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteDoctor(Doctor doctor) {
		DoctorDaoImpl dao = new DoctorDaoImpl();
		int rowsDeleted = dao.remove(doctor.getDoctorId());
		if(rowsDeleted == 0) {
			return Response.status(204).entity(doctor).build();
		} else {
			return Response.status(200).entity(doctor).build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateDoctor(Doctor update) {
		DoctorDaoImpl dao = new DoctorDaoImpl();
		Doctor existing = dao.findBy(update.getDoctorId());
	    Doctor doctor = dao.update(existing, update);
	    return Response.status(200).entity(doctor).build();
	}
	
}
