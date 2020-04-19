package com.PAFHospitalManagamentSystem.PAFHospitalManagamentSystem;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.PAFHospitalManagamentSystem.Appointment;

@Path("/Appointments")

public class AppointmentResource {
	
	AppointmnetRepository ar = new AppointmnetRepository();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Appointment> getAllAppointment() {
		return ar.getAllAppointments();
		
	}
	
	@POST
	@Path("/Appointment")
	@Consumes(MediaType.APPLICATION_JSON)
	public Appointment CreateAppointment(Appointment a1) {
		return ar.CreateAppointment(a1);
	}
	
}
