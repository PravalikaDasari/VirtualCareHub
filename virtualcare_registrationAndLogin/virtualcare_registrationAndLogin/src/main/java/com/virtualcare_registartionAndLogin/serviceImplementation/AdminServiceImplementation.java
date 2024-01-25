package com.virtualcare_registartionAndLogin.serviceImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualcare_registartionAndLogin.bean.AdminBean;
import com.virtualcare_registartionAndLogin.entity.AdminEntity;
import com.virtualcare_registartionAndLogin.repository.AdminRepository;
import com.virtualcare_registartionAndLogin.service.AdminService;
@Service
public class AdminServiceImplementation implements AdminService{
	@Autowired
	AdminRepository adminRepository;
	AdminEntity adminEntity=new AdminEntity();
	@Override
	public void save(AdminBean adminBean) {
		adminEntity.setAdmin_id(adminBean.getAdmin_id());
		adminEntity.setAdmin_name(adminBean.getAdmin_name());
		adminEntity.setAdmin_age(adminBean.getAdmin_age());
		adminEntity.setAdmin_gender(adminBean.getAdmin_gender());
		adminEntity.setAdmin_phone(adminBean.getAdmin_phone());
		adminEntity.setAdmin_designation(adminBean.getAdmin_designation());
		adminEntity.setAdmin_password(adminBean.getAdmin_password());
		adminEntity.setStatus(adminBean.getStatus());
		adminRepository.save(adminEntity);
		System.out.println("Registered");
	}
	@Override
	public String loginAdmin(Long admin_id, String admin_password) {
		Optional<AdminEntity> findByAdminId = adminRepository.findById(admin_id);
		if(findByAdminId.isPresent())
		{
			AdminEntity adminEntity1=findByAdminId.get();
			if(adminEntity1.getAdmin_password().equals(admin_password))
			{
				return "Login successfully";
			}
		}
		return "You are not registered or your login credentials are not correct";
	}

}
