package com.virtualcare_registartionAndLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualcare_registartionAndLogin.service.DoctorService;


@RestController
@RequestMapping("/doctor")
public class DoctorLoginController {
	@Autowired
	DoctorService doctorService;

	@GetMapping("/login/{doctor_id}/{doctor_password}")
	public String logeedOrNot(@PathVariable Long doctor_id, @PathVariable String doctor_password) {
		return doctorService.loginDoctor(doctor_id, doctor_password);
	}

}
