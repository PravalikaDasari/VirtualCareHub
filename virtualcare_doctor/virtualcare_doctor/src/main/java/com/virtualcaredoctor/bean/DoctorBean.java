package com.virtualcaredoctor.bean;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DoctorBean {

	private long doctor_id;
	private String doctor_name;
	private int doctor_age;
	private String doctor_gender;
	private long doctor_phone;
	private String doctor_specialization;
	private String doctor_password;
	
	private String state_code;
	
	private String branch_code;
	private String status;
	
}
