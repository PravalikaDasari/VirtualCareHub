package com.virtualcare.service;

import java.util.List;

import com.virtualcare.bean.AdminBean;
import com.virtualcare.exception.IdNotFoundException;

public interface AdminService 
{
	void saveAdmin(AdminBean admin);

	void updateAdmin(Long admin_id, String status) throws IdNotFoundException;

	AdminBean getAdminById(Long admin_id) throws IdNotFoundException;

	List<AdminBean> fetchAll();
}
