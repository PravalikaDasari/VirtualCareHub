package com.virtualcaredoctor.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "booking_appointment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingAppointmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appointment_id")
	private long appointment_id;
	
	@Column(name = "patient_phone")
	private long patient_phone;
	
	@Column(name = "state_code")
	private String state_code; 
	
	@Column(name = "branch_code")
	private String branch_code;
	
	@Column(name = "doctor_speciality")
	private String doctor_speciality;
	
	@Column(name = "appointment_date")
	private Date appointment_date;
	
	@Column(name = "appointment_time")
	private String appointment_time;
	
	@Column(name = "doctor_id")
	private long doctor_id;
	
	@Column(name = "admit_status")
	private String admit_status;
	
}
