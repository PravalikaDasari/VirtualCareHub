package com.virtualcare_registartionAndLogin.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorBean {
	private Long doctor_id;
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
