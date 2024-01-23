package com.patient.bean;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



/*import  lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
*/
@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "patient")
public class Patients implements Serializable{

 static final long serialVersionUID = 1L;

	@Id
	@Column(name = "patient_id")
	private Long id;

	@Column(name = "patient_name")
	private String name;
	
	@Column(name = "patient_age")
	private Integer age;
	
	@Column(name = "patient_gender")
	private String gender;
	
	@Column(name = "patient_password")
	private String password;
	
	@Column(name = "status")
	private String status;
	
	

    

	public Patients() {
		super();
	}

	
}