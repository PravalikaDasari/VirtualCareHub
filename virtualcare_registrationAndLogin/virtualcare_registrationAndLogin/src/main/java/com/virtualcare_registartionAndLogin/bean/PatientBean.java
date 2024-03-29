package com.virtualcare_registartionAndLogin.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PatientBean {
	private Long patient_id;
	private String patient_name;
	private int patient_age;
	private String patient_gender;
	private String patient_password;
	private String status;
}
