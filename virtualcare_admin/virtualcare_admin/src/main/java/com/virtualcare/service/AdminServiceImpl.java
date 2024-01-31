package com.virtualcare.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualcare.bean.AdminBean;
import com.virtualcare.entity.AdminEntity;
import com.virtualcare.exception.IdNotFoundException;
import com.virtualcare.repository.AdminRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Transactional
@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminrepository;
	@Override
	public void saveAdmin(AdminBean admin)
	{
		log.info("save method is started");
		AdminEntity entity =beanToEntity(admin);
		adminrepository.save(entity);
		log.info(entity.toString()+"\n save method is ended");
	}
	@Override
	public void updateAdmin(Long admin_id, String status) throws IdNotFoundException 
	{
		log.info("update method started, admin_id: "+admin_id);
		Optional<AdminEntity> optional = adminrepository.findById(admin_id);
		try {
			AdminEntity entity = optional.orElseThrow(() ->
			new IdNotFoundException("Admin not found with id-" + admin_id));
			log.info(entity.getAdmin_gender());
			adminrepository.updateById(admin_id,status);
		} catch (IdNotFoundException e) {
			throw new IdNotFoundException(e.getMessage());
		}
		log.info("updated method ended");
	}

	public AdminEntity beanToEntity(AdminBean admin)
	{
		try {
			AdminEntity entity = new AdminEntity();
			entity.setAdmin_name(admin.getAdmin_name());
			entity.setAdmin_age(admin.getAdmin_age());
			entity.setAdmin_gender(admin.getAdmin_gender());
			entity.setAdmin_designation(admin.getAdmin_designation());
			entity.setAdmin_phone(admin.getAdmin_phone());
			entity.setAdmin_password(admin.getAdmin_password());
			entity.setStatus(admin.getStatus());
			return entity;
		}catch(Exception e)
		{
			e.getMessage();
			return null;
		}
	}
	@Override
	public AdminBean getAdminById(Long admin_id) throws IdNotFoundException  
	{
		Optional<AdminEntity> optional = adminrepository.findById(admin_id);
		AdminEntity entity=null;
		try {
			entity = optional.orElseThrow(() ->
			new IdNotFoundException("Admin not found with id-" + admin_id));
		} catch (IdNotFoundException e) {
			throw new IdNotFoundException(e.getMessage());
		}
		return entityToBean(entity);
	}
	public AdminBean entityToBean(AdminEntity entity) 
	{
		AdminBean bean = new AdminBean();
		bean.setAdmin_id(entity.getAdmin_id());
		bean.setAdmin_name(entity.getAdmin_name());
		bean.setAdmin_age(entity.getAdmin_age());
		bean.setAdmin_gender(entity.getAdmin_gender());
		bean.setAdmin_designation(entity.getAdmin_designation());
		bean.setAdmin_phone(entity.getAdmin_phone());
		bean.setAdmin_password(entity.getAdmin_password());
		bean.setStatus(entity.getStatus());
		return bean;
	}
	@Override
	public List<AdminBean> fetchAll() 
	{
		List<AdminEntity> list = adminrepository.findAll();
		return list.stream().map(e->entityToBean(e)).toList();
	}
	
//	@Override
//	public void updateTest(PatientTrackingBean bean) 
//	{
//		Long id = bean.getTrack_id();
//		String test_status = bean.getTest_status();
//		byte[] file = bean.getTest_report();
//		String discharge_status = bean.getDischarge_status();
//		adminrepository.updateTestStatus(id,test_status,file,discharge_status);
//	}
	
	
	
	
	
}
