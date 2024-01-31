package com.virtualcare_registartionAndLogin.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

