package com.virtualcare_registartionAndLogin.serviceImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.virtualcare_registartionAndLogin.bean.DoctorBean;
import com.virtualcare_registartionAndLogin.entity.DoctorEntity;
import com.virtualcare_registartionAndLogin.repository.DoctorRepository;
import com.virtualcare_registartionAndLogin.service.DoctorService;
@Service
public class DoctorServiceImplementation implements DoctorService{
	@Autowired
   DoctorRepository doctorRepository;
	DoctorEntity doctorEntity=new DoctorEntity();
	public void save(DoctorBean doctorBean) {
		doctorEntity.setDoctor_id(doctorBean.getDoctor_id());
		doctorEntity.setBranch_code(doctorBean.getBranch_code());
		doctorEntity.setDoctor_age(doctorBean.getDoctor_age());
		doctorEntity.setDoctor_gender(doctorBean.getDoctor_gender());
		doctorEntity.setDoctor_name(doctorBean.getDoctor_name());
		doctorEntity.setDoctor_password(doctorBean.getDoctor_password());
		doctorEntity.setDoctor_phone(doctorBean.getDoctor_phone());
		doctorEntity.setDoctor_specialization(doctorBean.getDoctor_specialization());
		doctorEntity.setState_code(doctorBean.getState_code());
		doctorEntity.setStatus(doctorBean.getStatus());
		doctorRepository.save(doctorEntity);
		System.out.println("inserted");
	}
	@Override
	public String loginDoctor(Long doctor_id, String doctor_password) {
		Optional<DoctorEntity> findByDoctorId = doctorRepository.findById(doctor_id);
		if(findByDoctorId.isPresent()) {
			DoctorEntity doctorEntity2 = findByDoctorId.get();
			if(doctorEntity2.getDoctor_password().equals(doctor_password)) {
				return "successfully logged in";
				
			}
		}
		return "please register";
	}
	
	
}
