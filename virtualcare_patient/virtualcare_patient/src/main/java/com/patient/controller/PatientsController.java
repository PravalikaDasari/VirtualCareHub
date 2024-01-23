package com.patient.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient.bean.Patients;
import com.patient.services.PatientsServiceImpl;


//import lombok.extern.slf4j.Slf4j;
//@Slf4j
@RestController
public class PatientsController {
	@Autowired
	private PatientsServiceImpl patientsService;

	   @PostMapping(path="/create")
	    public ResponseEntity<Patients> savePatient(@RequestBody Patients patients) {
		   System.out.println("post mapping");

		   patientsService.save(patients);

			ResponseEntity<Patients> responseEntity = new ResponseEntity<>(patients, HttpStatus.CREATED);
			return responseEntity;
	    }
	@GetMapping(path = "/{id}")
	public ResponseEntity<Patients> get(@PathVariable Long id) {
//		log.info("Fetching players {}", id);

		Patients patients = patientsService.get(id);

		ResponseEntity<Patients> responseEntity = new ResponseEntity<>(patients,
				HttpStatus.OK);
		return responseEntity;
	}
	
	 @DeleteMapping("/delete/{id}") 
	 public String deleteEmployee(@PathVariable("id") Long id) { 
		 patientsService.deletePatientById(id);
	        return "File deleted "; 
	 }
	
	

}
