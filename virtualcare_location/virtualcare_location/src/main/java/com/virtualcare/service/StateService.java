package com.virtualcare.service;

import java.util.List;

import com.virtualcare.bean.StateBean;


public interface StateService {

	void save(StateBean statebean);

	void deleteByCode(String state_code);
	
	void update(StateBean statebean,String state_code);
	
	List<StateBean> getAll();
	
	
}
