package com.book.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "booking_appointment")
public class BookAppointment implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appointment_id")
	private Long id;

	@Column(name = "patient_phone")
	private Long phone;
	
	@Column(name = "state_code")
	private String state_code;
	
	@Column(name = "branch_code")
	private String branch_code;
	
	@Column(name = "doctor_speciality")
	private String doctor_speciality;
	
	@Column(name = "appointment_date")
	private Date appointment_date;
	
	@Column(name = "doctor_id")
	private Long doctor_id;
	
	@Column(name = "admit_status")
	private String admit_status;
	
	@Column(name = "appointment_time")
	private String appointment_time;

	public BookAppointment() {
		super();
	}
	
	
	

}
