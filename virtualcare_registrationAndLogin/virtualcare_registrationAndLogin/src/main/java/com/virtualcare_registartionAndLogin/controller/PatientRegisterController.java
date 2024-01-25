package com.virtualcare_registartionAndLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualcare_registartionAndLogin.bean.PatientBean;
import com.virtualcare_registartionAndLogin.service.PatientService;
@RestController
@RequestMapping(path = "/patient")
public class PatientRegisterController {
	@Autowired
	PatientService patientService;
	@PostMapping(path = "/register")
	public String register(@RequestBody PatientBean patientBean)
	{
		patientService.save(patientBean);
		return "Patient Registered with credentials";
	}
}
