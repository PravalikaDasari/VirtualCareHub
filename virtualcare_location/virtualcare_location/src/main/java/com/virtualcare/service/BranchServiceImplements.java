package com.virtualcare.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualcare.bean.BranchBean;
import com.virtualcare.entity.BranchEntity;
import com.virtualcare.exceptions.IdNotFoundException;
import com.virtualcare.repository.BranchRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BranchServiceImplements implements BranchService {

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
	public BranchBean getById(String branch_code) throws IdNotFoundException {
		BranchBean bean = new BranchBean();
		Optional<BranchEntity> entity = branchRepository.findById(branch_code);
		if (entity.isPresent()) {
			bean.setBranch_code(entity.get().getBranch_code());
			bean.setBranch_name(entity.get().getBranch_name());
			bean.setState_code(entity.get().getState_code());
			bean.setStatus(entity.get().getStatus());
		} else {
			throw new IdNotFoundException("IdNotFound");
		}
		return bean;

	}

	@Override
	public List<BranchBean> getAll() {
		List<BranchEntity> findAll = branchRepository.findAll();
		List<BranchBean> list1 =new ArrayList<>();
		for (BranchEntity entity : findAll) {
			BranchBean bean = new BranchBean();
			bean.setBranch_code(entity.getBranch_code());
			bean.setBranch_name(entity.getBranch_name());
			bean.setState_code(entity.getState_code());
			bean.setStatus(entity.getStatus());
			list1.add(bean);
		}
		return list1;

	}

}
