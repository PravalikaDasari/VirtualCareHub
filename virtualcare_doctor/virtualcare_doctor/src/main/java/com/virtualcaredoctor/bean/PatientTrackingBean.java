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
public class PatientTrackingBean {

	private long track_id;
	private String test_name;
	private String date;
	private String test_status;
	private byte[]  test_report;
	private String discharge_status;
	private long doctor_id;
	private long patient_phone;
	
}
