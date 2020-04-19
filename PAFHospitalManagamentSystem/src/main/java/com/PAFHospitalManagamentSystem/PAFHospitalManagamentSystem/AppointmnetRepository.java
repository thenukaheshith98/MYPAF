package com.PAFHospitalManagamentSystem.PAFHospitalManagamentSystem;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import model.PAFHospitalManagamentSystem.Appointment;

public class AppointmnetRepository {
	
	Connection con =null;
	List<Appointment> appointment;
	public AppointmnetRepository() {
		
		String url ="jdbc:mysql://localhost:3306/appointmentapiproject?serverTimezone=UTC";
		String username = "root";
		String password = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);	
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		appointment = new ArrayList<Appointment>();
		
		Appointment a1 = new Appointment();
		a1.setP_name("g.h. perera");
		a1.setP_age(34);
		a1.setType_of_case("fewer");
		a1.setD_name("nakawita i.m.");
		
		Appointment a2 = new Appointment();
		a2.setP_name("t.i alwis");
		a2.setP_age(14);
		a2.setType_of_case("knee pain");
		a2.setD_name("perera k.f");
		
		Appointment a3 = new Appointment();
		a3.setP_name("w.d. jennifer");
		a3.setP_age(56);
		a3.setType_of_case("migraine");
		a3.setD_name("premasiri r.n.");
		
		appointment.add(a1);
		appointment.add(a2);
		appointment.add(a3);
		
	}
	
	public List<Appointment> getAllAppointments() {
		return appointment;
	}
	
	public Appointment CreateAppointment(Appointment a1) {
		String insertSql = "INSERT INTO `appointmnets`(`p_name`, `p_age`, `type_of_case`, `d_name`) VALUES (?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(insertSql);
			st.setString(1, a1.p_name);
			st.setInt(2, a1.p_age);
			st.setString(3, a1.type_of_case);
			st.setString(4, a1.d_name);
			
			st.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		appointment.add(a1);
		System.out.println(appointment); 
		return a1;
	}
}
