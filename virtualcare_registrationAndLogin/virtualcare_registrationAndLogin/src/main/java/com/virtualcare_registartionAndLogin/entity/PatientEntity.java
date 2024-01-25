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
import lombok.ToString;

@Entity
@Table(name = "patient_registration")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PatientEntity {
	@Id
	@Column(name = "patient_id")
	 Long patient_id;
	@Column(name = "patient_name")
	 String patient_name;
	@Column(name = "patient_age")
	 int patient_age;
	@Column(name = "patient_gender")
	 String patient_gender;
	@Column(name = "patient_password")
	 String patient_password;
	@Column(name = "status")
	 String status;
}
