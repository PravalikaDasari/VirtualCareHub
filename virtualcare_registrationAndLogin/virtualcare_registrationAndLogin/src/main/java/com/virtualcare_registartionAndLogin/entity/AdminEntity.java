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
@Table(name = "AdminRegistration")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdminEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	 Long admin_id;
	@Column(name = "admin_name")
	 String admin_name;
	@Column(name = "admin_age")
	 int admin_age;
	@Column(name = "admin_gender")
	 String admin_gender;
	@Column(name = "admin_phone")
	 Long admin_phone;
	@Column(name = "admin_designation")
	 String admin_designation;
	@Column(name = "admin_password")
	 String admin_password;
	@Column(name = "status")
	 String status;
}
