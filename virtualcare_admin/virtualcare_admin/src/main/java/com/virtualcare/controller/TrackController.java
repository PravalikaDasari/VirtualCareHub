package com.virtualcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualcare.bean.PatientTrackingBean;
import com.virtualcare.service.AdminService;

@RestController
@RequestMapping(name = "/track")
public class TrackController 
{
	@Autowired
	private AdminService adminService;
	
	@GetMapping(name = "/save")
	public ResponseEntity<PatientTrackingBean> saveTest(@RequestBody PatientTrackingBean bean)
	{
		adminService.saveTest(bean);
		ResponseEntity<PatientTrackingBean> entity = new ResponseEntity<>(bean,HttpStatus.CREATED);
		return entity;
	}
	
}
