package com.virtualcaredoctor.entity;

import com.virtualcaredoctor.bean.BranchBean;
import com.virtualcaredoctor.bean.StateBean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Entity
@Table(name="doctor")
public class DoctorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="doctor_id")
	private long doctor_id;
	
	@Column(name="doctor_name")
	private String doctor_name;
	
	@Column(name="doctor_age")
	private int doctor_age;
	
	@Column(name="doctor_gender")
	private String doctor_gender;
	
	@Column(name="doctor_phone")
	private long doctor_phone;
	
	@Column(name="doctor_specialization")
	private String doctor_specialization;
	
	@Column(name="doctor_password")
	private String doctor_password;
	
	@Column(name="state_code")
	private String state_code;
	
	@Column(name="branch_code")
	private String branch_code;
	
	@Column(name="status")
	private String status;
	
}