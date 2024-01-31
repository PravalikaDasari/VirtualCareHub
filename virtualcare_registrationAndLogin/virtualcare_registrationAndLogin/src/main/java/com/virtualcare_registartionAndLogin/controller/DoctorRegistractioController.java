package com.virtualcare_registartionAndLogin.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtualcare_registartionAndLogin.bean.DoctorBean;
import com.virtualcare_registartionAndLogin.repository.DoctorRepository;
import com.virtualcare_registartionAndLogin.service.DoctorService;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/doctor")
@Slf4j
//port id is 8081
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
