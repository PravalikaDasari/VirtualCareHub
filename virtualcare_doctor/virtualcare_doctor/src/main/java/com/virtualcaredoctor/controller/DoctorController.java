package com.virtualcaredoctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtualcaredoctor.bean.BookingAppointmentBean;
import com.virtualcaredoctor.entity.BookingAppointmentEntity;
import com.virtualcaredoctor.repository.BookingAppointmentRepository;
import com.virtualcaredoctor.service.BookingAppointmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/doctor")
@Slf4j
//port id is 8081
public class DoctorController {

	@Autowired
	BookingAppointmentService bookingAppointmentService;
	
	@Autowired
	BookingAppointmentRepository  bookingAppointmentRepository;
	
	@GetMapping("/check")
	public String check() {
		log.info("welcome to project");
		return "welcome to project";
	}
	
	
	@PostMapping("/saveAppointedPatient")
	public String saveAppointedPatient(@RequestBody BookingAppointmentBean bean)
	{
		
		bookingAppointmentService.saveAppointedPatient(bean);
		return "inserted patient record";
	}
	
	@GetMapping("/getById/{appointment_id}")
	public BookingAppointmentBean getById(@PathVariable long appointment_id)
	{
		 BookingAppointmentBean bean = bookingAppointmentService.getById(appointment_id);
		 return bean;
	}

	
	@GetMapping("/updateadmitcolumn/{appointment_id}/{status}")
	public String updateAdmitStatus(@PathVariable long appointment_id,@PathVariable  String status) 
	{
	
		BookingAppointmentBean bean = bookingAppointmentService.getById(appointment_id);
		log.info("bean {}",bean);
		bean.setAdmit_status(status);
		log.info("bean {}",bean);
		bookingAppointmentService.saveAppointedPatient(bean);
		log.info("bean {}",bean);
		//bookingAppointmentService.updateAdmitStatus(appointment_id, status);
		return "status updated";
		
	}
}







