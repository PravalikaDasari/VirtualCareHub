package com.virtualcare_registartionAndLogin.service;

import com.virtualcare_registartionAndLogin.bean.AdminBean;

public interface AdminService {
	public void save(AdminBean adminBean);
	public String loginAdmin(Long admin_id,String admin_password);
}
