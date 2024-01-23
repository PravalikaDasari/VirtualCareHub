package com.virtualcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualcare.bean.StateBean;
import com.virtualcare.repository.StateRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Transactional
@Slf4j
@Service
public class StateServiceImplements implements StateService{

	@Autowired
	private StateRepository stateRepository;
	@Override
	public void save(StateBean statebean) {
		stateRepository.save(statebean);
	}
	@Override
	public void deleteByCode(String state_code) {
	stateRepository.deleteById(state_code);
     
	}
	
	@Override
	public List<StateBean> getAll() {
		return stateRepository.findAll();
	}
	@Override
	public void update(StateBean statebean, String state_code) {
		stateRepository.save(statebean);
	}
	
	public Optional<StateBean> getById(String state_code){
		Optional<StateBean> getbyid=stateRepository.findById(state_code);
		return getbyid;
		
	}
	
}
