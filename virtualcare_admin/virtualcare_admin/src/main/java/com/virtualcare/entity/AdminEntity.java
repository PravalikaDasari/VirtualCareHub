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
@Table(name = "admin")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdminEntity 
{
	@Id
	@Column(name = "admin_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long admin_id;
	
	@Column(name="admin_name")
	private String admin_name;
	
	@Column(name="admin_age")
	private int admin_age;
	
	@Column(name="admin_gender")
	private String admin_gender;
	
	@Column(name="admin_phone")
	private Long admin_phone;
	
	@Column(name="admin_designation")
	private String admin_designation;
	
	@Column(name="admin_password")
	private String admin_password;
	
	@Column(name="status")
	private String status;
}
