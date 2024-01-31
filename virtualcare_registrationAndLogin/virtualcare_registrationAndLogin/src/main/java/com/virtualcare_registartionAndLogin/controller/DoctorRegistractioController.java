package com.virtualcare_registartionAndLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualcare_registartionAndLogin.bean.DoctorBean;
import com.virtualcare_registartionAndLogin.service.DoctorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/doctor")
@Slf4j
public class DoctorRegistractioController {
	@Autowired
	DoctorService doctorService;
	@GetMapping("/get")
	public String get()
	{
		log.info("HEllo");
		return "Welcome to project";
	}
	@PostMapping(path = "/insert")
	public String insert(@RequestBody DoctorBean doctorBean)
	{
		doctorService.save(doctorBean);
		return "inserted";
		
	}
}
