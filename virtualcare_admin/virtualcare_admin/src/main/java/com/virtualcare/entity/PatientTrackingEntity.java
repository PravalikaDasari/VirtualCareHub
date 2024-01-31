package com.virtualcare.entity;


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
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientTrackingEntity 
{
	@Id
	@Column(name="track_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long track_id;
	
	@Column(name="test_name")
	private String test_name;
	
	@Column(name="date")
	private String date;
	
	@Column(name="test_status")
	private String test_status;
	
	@Column(name="test_report")
	private byte[] test_report;
	
	@Column(name="discharge_status")
	private String discharge_status;
	
	@Column(name="doctor_id")
	private Long doctor_id;
	
	@Column(name="patient_phone")
	private Long patient_phone;
}
