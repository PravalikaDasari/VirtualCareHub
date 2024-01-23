package com.virtualcare.service;

import java.util.List;

import com.virtualcare.bean.BranchBean;

public interface BranchService {

	void save(BranchBean branchbean);

	void deleteByCode(String branch_code);

	void update(BranchBean branchbean, String branch_code);

	List<BranchBean> getAll();
	
	BranchBean getById(String branch_code);

}
