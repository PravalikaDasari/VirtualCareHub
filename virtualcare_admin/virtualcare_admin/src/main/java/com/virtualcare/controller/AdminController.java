package com.virtualcare.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.virtualcare.bean.AdminBean;
import com.virtualcare.bean.PatientTrackingBean;
import com.virtualcare.exception.IdNotFoundException;
import com.virtualcare.service.AdminService;
import com.virtualcare.service.TrackingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController
{
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private TrackingService trackingService;
	
	@GetMapping(path = "/save")
	public ResponseEntity<AdminBean> saveAdmin(@RequestBody AdminBean admin)
	{
		log.info("save admin method started: "+admin.toString());
		adminService.saveAdmin(admin);
		log.info("record created:"+admin.toString());
		return new ResponseEntity<>(admin,HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/update/{admin_id}/{status}")
	public void updateAdmin(@PathVariable Long admin_id ,@PathVariable String status ) throws IdNotFoundException
	{
		log.info("update method started: "+admin_id);
		try {
			adminService.updateAdmin(admin_id,status);
		} catch (IdNotFoundException e) {
			throw new IdNotFoundException(e.getMessage());
		}
		log.info("update method ended");
	}
	
	@GetMapping(path = "/getById/{admin_id}")
	public ResponseEntity<AdminBean> getAdmin(@PathVariable Long admin_id) throws IdNotFoundException 
	{
		AdminBean bean=null;
		try {
			bean = adminService.getAdminById(admin_id);
		} catch (IdNotFoundException e) {
			throw new IdNotFoundException(e.getMessage());
		}
		return new ResponseEntity<>(bean,HttpStatus.FOUND);
	}
	
	@GetMapping(path="/getAll")
	public ResponseEntity<List<AdminBean>> getAll()
	{
		log.info("get all method started ");
		List<AdminBean> list = adminService.fetchAll();
		log.info("get all method ended ");
		return new ResponseEntity<>(list,HttpStatus.FOUND) ;
	}
	
	@PostMapping(path="/update/{track_id}/{test_status}/{discharge_status}")
	public ResponseEntity<String> updateTrack(@RequestParam("file") MultipartFile file,@PathVariable Long track_id ,
					@PathVariable String test_status,@PathVariable String discharge_status)
	{
		 try {
	            if (!file.isEmpty()) 
	            {
	                String fileName = file.getOriginalFilename();	
	                byte[] fileData = file.getBytes();

	                PatientTrackingBean bean = new PatientTrackingBean();
	                bean.setTest_report(fileData);
	                bean.setTrack_id(track_id);
	                bean.setTest_status(test_status);
	                bean.setDischarge_status(discharge_status);

	                trackingService.updateTest(bean);

	                return ResponseEntity.ok("File uploaded successfully: " + fileName);
	            } else {
	                return ResponseEntity.badRequest().body("File is empty or not provided.");
	            }
	        } catch (IOException e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file.");
	        }
	}
	@GetMapping(path="/getAllTracks")
	public ResponseEntity<List<PatientTrackingBean>> getAllTracks()
	{
		log.info("get all track records method started");
		List<PatientTrackingBean> list = trackingService.fetchAll();
		log.info("get all track records method ended");
		return new ResponseEntity<>(list,HttpStatus.CREATED) ;
	}
	
}
