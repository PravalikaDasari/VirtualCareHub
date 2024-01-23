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
		AdminEntity entity =beanToEntity(admin);
		adminrepository.save(entity);
		log.info(entity.toString());
	}
	@Override
	public void updateAdmin(Long admin_id, String status) {
			adminrepository.updateById(admin_id,status);
	}

	public AdminEntity beanToEntity(AdminBean admin)
	{
		AdminEntity entity = new AdminEntity();
		entity.setAdmin_name(admin.getAdmin_name());
		entity.setAdmin_age(admin.getAdmin_age());
		entity.setAdmin_gender(admin.getAdmin_gender());
		entity.setAdmin_designation(admin.getAdmin_designation());
		entity.setAdmin_phone(admin.getAdmin_phone());
		entity.setAdmin_password(admin.getAdmin_password());
		entity.setStatus(admin.getStatus());
		return entity;
	}
	@Override
	public AdminBean getAdminById(Long admin_id) throws IdNotFoundException 
	{
		Optional<AdminEntity> optional = adminrepository.findById(admin_id);
		AdminEntity entity = optional.orElseThrow(() ->
		new IdNotFoundException("Admin not found with id-" + admin_id));
		AdminBean bean = entityToBean(entity);
		return bean;
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
		List<AdminBean> beans = list.stream().map((e)->entityToBean(e)).toList();
		return beans;
	}
}
