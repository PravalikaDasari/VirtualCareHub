package com.virtualcaredoctor.entity;

import java.sql.Date;

import com.virtualcaredoctor.bean.DoctorBean;
import com.virtualcaredoctor.bean.PatientBean;

import jakarta.annotation.Generated;
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
@Table(name = "patient_tracking")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientTrackingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "track_id")
	private long track_id;
	
	@Column(name = "test_name")
	private String test_name;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "test_status")
	private String test_status;
	
	@Column(name = "test_report")
	private byte[]  test_report;
	
	@Column(name = "discharge_status")
	private String discharge_status;
	
	@Column(name = "doctor_id")
	private long doctor_id;
	
	@Column(name = "patient_phone")
	private long patient_phone;

	
	
}
