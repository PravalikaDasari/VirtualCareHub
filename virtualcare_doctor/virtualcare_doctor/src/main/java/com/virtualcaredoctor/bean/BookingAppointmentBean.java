package com.virtualcaredoctor.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingAppointmentBean {

	private long appointment_id;
	
	private long patient_phone;
	
	private String state_code; 
	
	private String branch_code;
	
	private String doctor_speciality;
	
	private String appointment_date;
	
	private String appointment_time;
	
	private long doctor_id;
	
	private String admit_status;
	
	

	

	
}
