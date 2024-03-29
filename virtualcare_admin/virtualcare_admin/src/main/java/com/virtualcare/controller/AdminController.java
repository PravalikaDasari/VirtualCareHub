package com.virtualcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualcare.bean.AdminBean;
import com.virtualcare.exception.IdNotFoundException;
import com.virtualcare.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController
{
	@Autowired
	private AdminService adminService;
	
	@GetMapping(path = "/save")
	public ResponseEntity<AdminBean> saveAdmin(@RequestBody AdminBean admin)
	{
		adminService.saveAdmin(admin);
		ResponseEntity<AdminBean> bean =new ResponseEntity<>(admin,HttpStatus.CREATED);
		return bean;
	}
	
	@GetMapping(path = "/update/{admin_id}/{status}")
	public String updateAdmin(@PathVariable Long admin_id ,@PathVariable String status ) throws IdNotFoundException
	{
		adminService.updateAdmin(admin_id,status);
		return "Updated Successfully";
	}
	
	@GetMapping(path = "/getById/{admin_id}")
	public ResponseEntity<AdminBean> getAdmin(@PathVariable Long admin_id) throws IdNotFoundException
	{
		AdminBean bean =adminService.getAdminById(admin_id);
		ResponseEntity<AdminBean> entity =new ResponseEntity<>(bean,HttpStatus.CREATED);
		return entity;
	}
	
	@GetMapping(path="/getAll")
	public ResponseEntity<List<AdminBean>> getAll()
	{
		List<AdminBean> list = adminService.fetchAll();
		ResponseEntity<List<AdminBean>> entity =new ResponseEntity<>(list,HttpStatus.CREATED) ;
		return entity;
	}
	
}
