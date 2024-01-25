package com.virtualcare_registartionAndLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualcare_registartionAndLogin.bean.AdminBean;
import com.virtualcare_registartionAndLogin.service.AdminService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/admin")
@Slf4j
public class AdminRegistrationController {
	@Autowired
	AdminService adminService;
	@PostMapping(path = "/register")
	public String register(@RequestBody AdminBean adminBean)
	{
		adminService.save(adminBean);
		return "inserted";
	}
}
