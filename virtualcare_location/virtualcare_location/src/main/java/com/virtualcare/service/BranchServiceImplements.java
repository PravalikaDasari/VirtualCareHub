package com.virtualcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualcare.bean.BranchBean;
import com.virtualcare.entity.BranchEntity;
import com.virtualcare.repository.BranchRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public  class BranchServiceImplements implements BranchService {

	@Autowired
	private BranchRepository branchRepository;

	@Override
	public void save(BranchBean branchbean) {
		BranchEntity entity = new BranchEntity();
		entity.setBranch_code(branchbean.getBranch_code());
		entity.setBranch_name(branchbean.getBranch_name());
		entity.setState_code(branchbean.getState_code());
		entity.setStatus(branchbean.getStatus());
		branchRepository.save(entity);
	}

	@Override
	public void deleteByCode(String branch_code) {
		branchRepository.deleteById(branch_code);
	}

	@Override
	public void update(BranchBean branchbean, String branch_code) {
		BranchEntity entity = new BranchEntity();
		entity.setBranch_code(branchbean.getBranch_code());
		entity.setBranch_name(branchbean.getBranch_name());
		entity.setState_code(branchbean.getState_code());
		entity.setStatus(branchbean.getStatus());
		branchRepository.save(entity);
	}

	@Override
	public List<BranchBean> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BranchBean getById(String branch_code) {
		BranchBean bean = new BranchBean();
		Optional<BranchEntity> entity = branchRepository.findById(branch_code);
		bean.setBranch_code(entity.get().getBranch_code());
		bean.setBranch_name(entity.get().getBranch_name());
		bean.setState_code(entity.get().getState_code());
		bean.setStatus(entity.get().getStatus());
		return bean;
	}

//	public BranchBean getBybranchcode(String branch_code) {
//		BranchBean bean = new BranchBean();
//		Optional<BranchEntity> entity = branchRepository.findById(branch_code);
//		bean.setBranch_code(entity.get().getBranch_code());
//		bean.setBranch_name(entity.get().getBranch_name());
//		bean.setState_code(entity.get().getState_code());
//		bean.setStatus(entity.get().getStatus());
//		return bean;
//
//	}

//	@Override
//	public List<BranchBean> getAll() {
//		BranchEntity entity = new BranchEntity();
//		
//		return branchRepository.findAll();
//	}

}
