package com.virtualcare.controller;

import java.util.List;

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
import com.virtualcare.service.BranchService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/branch")
public class BranchController {

	@Autowired
	private BranchService branchService;
	
	@PostMapping(path="/savebranch")
	public ResponseEntity<BranchBean> save(@RequestBody BranchBean branchbean){
		log.info("saving branch details{}",branchbean);
		branchService.save(branchbean);
		ResponseEntity<BranchBean> responeentity=new ResponseEntity<>(branchbean,HttpStatus.CREATED);
		return responeentity;
	}
	
	
//	@GetMapping(path = "/getAllbranches")
//	public ResponseEntity<List<BranchBean>> getAll() {
//		log.info("getting all details");
//		List<BranchBean> getalldata = branchService.getAll();
//		ResponseEntity<List<BranchBean>> responseEntity = new ResponseEntity<>(getalldata, HttpStatus.OK);
//		return responseEntity;
//	}
	
	
	@PutMapping(path = "/updatebranch")
	public BranchBean update(@RequestBody BranchBean branchbean) {
		branchService.save(branchbean);
		log.info("updated");
		return branchbean;
		
	}
	
	@DeleteMapping(path = "/delete/{branch_code}")
	public String deleteById(@PathVariable String branch_code) {
		branchService.deleteByCode(branch_code);
		return "deleted";
		
	}
	
	
	@GetMapping(path = "/getbyid/{branch_code}")
	public BranchBean getById(@PathVariable String branch_code){
		BranchBean getbyid= branchService.getById(branch_code);
		//ResponseEntity<List<BranchBean>> responseEntity = new ResponseEntity<>(getbyid, HttpStatus.OK);
		return getbyid ;
	}
}
