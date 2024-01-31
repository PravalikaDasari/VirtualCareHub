package com.book.bean;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class BookAppointment {

	
	private Long id;
	private Long phone;
	private String state_code;
	private String branch_code;
	private String doctor_speciality;
	private Date appointment_date;
	private Long doctor_id;
	private String admit_status;
	private String appointment_time;

	public BookAppointment() {
		super();
	}
	
	
	

}
