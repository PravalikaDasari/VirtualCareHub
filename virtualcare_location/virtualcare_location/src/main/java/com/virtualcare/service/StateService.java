package com.virtualcare.service;

import java.util.List;

import com.virtualcare.bean.BranchBean;
import com.virtualcare.bean.StateBean;
import com.virtualcare.exceptions.IDNotValid;
import com.virtualcare.exceptions.IdNotFoundException;


public interface StateService {

	void save(StateBean statebean);

	void deleteByCode(String state_code);
	
	void update(StateBean statebean,String state_code);
	
	List<StateBean> getAll();
	

	StateBean getById(String state_code) throws IDNotValid;

	
	
}
