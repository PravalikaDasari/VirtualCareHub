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
public class AdminBean 
{
	private Long admin_id;
	private String admin_name;
	private int admin_age;
	private String admin_gender;
	private Long admin_phone;
	private String admin_designation;
	private String admin_password;	
	private String status;
}
