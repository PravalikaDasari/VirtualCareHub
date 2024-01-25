package com.patient.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.patient.bean.PatientsDto;
import com.patient.entity.Patients;
import com.patient.services.PatientsServiceImpl;


//import lombok.extern.slf4j.Slf4j;
//@Slf4j
@RestController
public class PatientsController {
	@Autowired
	private PatientsServiceImpl patientsService;

	   @PostMapping(path="/create")
	    public ResponseEntity<PatientsDto> savePatient(@RequestBody PatientsDto patientsDto) {
		   System.out.println("post mapping");

		   patientsService.save(patientsDto);

			ResponseEntity<PatientsDto> responseEntity = new ResponseEntity<>(patientsDto, HttpStatus.CREATED);
			return responseEntity;
	    }
	@GetMapping(path = "/{id}")
	public ResponseEntity<Patients> get(@PathVariable Long id) {
//		log.info("Fetching players {}", id);

		Patients patientsDto = patientsService.get(id);

		ResponseEntity<Patients> responseEntity = new ResponseEntity<>(patientsDto,
				HttpStatus.OK);
		return responseEntity;
	}
	
	 @DeleteMapping("/delete/{id}") 
	 public String deleteEmployee(@PathVariable("id") Long id) { 
		 patientsService.deletePatientById(id);
	        return "File deleted "; 
	 }
	
	 @GetMapping("/login/{id}/{password}")
		public Optional<Patients> loginToPatientAccount(@PathVariable Long id, @PathVariable String password) {
			return patientsService.loginPatient(id,password);
		}

}
