package com.virtualcare.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualcare.bean.BranchBean;
import com.virtualcare.bean.StateBean;
import com.virtualcare.entity.BranchEntity;
import com.virtualcare.entity.StateEntity;
import com.virtualcare.exceptions.IDNotValid;
import com.virtualcare.repository.StateRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Transactional
@Slf4j
@Service
public class StateServiceImplements implements StateService {

	@Autowired
	private StateRepository stateRepository;

	@Override
	public void save(StateBean statebean) {
		StateEntity entity = new StateEntity();
		entity.setNo_of_branches(statebean.getNo_of_branches());
		entity.setState_code(statebean.getState_code());
		entity.setState_name(statebean.getState_name());
		entity.setStatus(statebean.getStatus());
		stateRepository.save(entity);
	}

	@Override
	public void deleteByCode(String state_code) {
		stateRepository.deleteById(state_code);
	}

	@Override
	public List<StateBean> getAll() {
		List<StateEntity> findall = stateRepository.findAll();
		List<StateBean> list1 = new ArrayList<>();
		for (StateEntity entity : findall) {
			StateBean bean = new StateBean();
			bean.setNo_of_branches(entity.getNo_of_branches());
			bean.setState_code(entity.getState_code());
			bean.setState_name(entity.getState_name());
			bean.setStatus(entity.getStatus());
			list1.add(bean);
		}
		return list1;
	}

	@Override
	public void update(StateBean statebean, String state_code) {
		StateEntity entity = new StateEntity();
		entity.setNo_of_branches(statebean.getNo_of_branches());
		entity.setState_code(statebean.getState_code());
		entity.setState_name(statebean.getState_name());
		entity.setStatus(statebean.getStatus());
		stateRepository.save(entity);
	}

	@Override
	public StateBean getById(String state_code) throws IDNotValid {
		StateBean bean = new StateBean();
		Optional<StateEntity> entity = stateRepository.findById(state_code);
         if(entity.isPresent()) {
        	 bean.setNo_of_branches(entity.get().getNo_of_branches());
        	 bean.setState_code(entity.get().getState_code());
        	 bean.setState_name(entity.get().getState_name());
        	 bean.setStatus(entity.get().getStatus());
         }
         else {
        	 throw new IDNotValid("IDNotFound");
         }
		return bean;
	}

}
