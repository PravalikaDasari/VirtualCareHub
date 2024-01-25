package com.virtualcare_registartionAndLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualcare_registartionAndLogin.service.AdminService;

@RestController
@RequestMapping(path = "/admin")
public class AdminLoginController {
	@Autowired
	AdminService adminService;
	@GetMapping(path = "/login/{admin_id}/{admin_password}")
	public String login(@PathVariable Long admin_id,@PathVariable String admin_password)
	{
		return adminService.loginAdmin(admin_id, admin_password);
	}
}
