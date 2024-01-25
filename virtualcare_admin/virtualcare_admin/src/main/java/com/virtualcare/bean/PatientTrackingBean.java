package com.virtualcare.bean;


import java.sql.Blob;
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
	private String test_id;
	private String date;
	private String test_status;
	private Blob test_report;
	private String discharge_status;
	private Long doctor_id;
	private Long patient_phone;
}
