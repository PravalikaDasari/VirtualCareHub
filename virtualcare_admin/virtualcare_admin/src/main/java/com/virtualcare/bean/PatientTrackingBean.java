package com.virtualcare.bean;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientTrackingBean
{
	private Long track_id;
	private String test_name;
	private String date;
	private String test_status;
	private byte[] test_report;
	private String discharge_status;
	private Long doctor_id;
	private Long patient_phone;
}
