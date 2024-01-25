package com.virtualcare_registartionAndLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualcare_registartionAndLogin.service.PatientService;

@RestController
@RequestMapping(path = "/patient")
public class PatientLoginController {
	@Autowired
	PatientService patientService;
	@GetMapping(path = "/login/{patient_id}/{patient_password}")
	public String login(@PathVariable Long patient_id,@PathVariable String patient_password)
	{
	  return patientService.loginOrNot(patient_id, patient_password);
	  
	}
	
}
