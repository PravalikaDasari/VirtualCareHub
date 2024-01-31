package com.virtualcare.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualcare.bean.BranchBean;
import com.virtualcare.bean.StateBean;
import com.virtualcare.exceptions.IDNotValid;
import com.virtualcare.exceptions.IdNotFoundException;
import com.virtualcare.service.StateService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/state")
public class StateController {

	@PostMapping
	public String get() {
		log.info("Hiii");
		return "Hiii";

	}

	@Autowired
	private StateService stateService;

	@PostMapping(path = "/save")
	public ResponseEntity<StateBean> save(@RequestBody StateBean statebean) {
		log.info("saving state details {}", statebean);
		stateService.save(statebean);
		ResponseEntity<StateBean> responseEntity = new ResponseEntity<>(statebean, HttpStatus.CREATED);
		return responseEntity;

	}

	@DeleteMapping(path = "/delete/{state_code}")
	public String deleteBycode(@PathVariable("state_code") String state_code) {
		stateService.deleteByCode(state_code);
		return "deleted";
	}

	@PutMapping(path = "/update")
	public StateBean update(@RequestBody StateBean statebean) {
		stateService.save(statebean);
		log.info("updated");
		return statebean;

	}

	@GetMapping(path = "/getAll")
	public ResponseEntity<List<StateBean>> getAll() {
		log.info("getting all details");
		List<StateBean> getalldata = stateService.getAll();
		ResponseEntity<List<StateBean>> responseEntity = new ResponseEntity<>(getalldata, HttpStatus.OK);
		return responseEntity;
	}


	@GetMapping(path = "/getbyid/{state_code}")
	public StateBean getById(@PathVariable String state_code) throws IDNotValid{
		StateBean getbyid= stateService.getById(state_code);
		return getbyid ;
	}
	
}
