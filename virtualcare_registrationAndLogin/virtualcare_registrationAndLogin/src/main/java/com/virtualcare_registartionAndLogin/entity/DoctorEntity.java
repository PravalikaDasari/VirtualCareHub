package com.virtualcare_registartionAndLogin.entity;

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

@Entity
@Table(name="DoctorRegistration")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="doctor_id")
	long doctor_id;
	@Column(name ="doctor_name")
	String doctor_name;
	@Column(name ="doctor_age")
	int doctor_age;
	@Column(name ="doctor_gender")
	String doctor_gender;
	@Column(name ="doctor_phone")
	Long doctor_phone;
	@Column(name ="doctor_specialization")
	String doctor_specialization;
	@Column(name ="doctor_password")
	String doctor_password;
	@Column(name ="state_code")
	String state_code;
	@Column(name ="branch_code")
	String branch_code;
	@Column(name ="status")
	String status;
	
}
