package com.virtualcare_registartionAndLogin.serviceImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualcare_registartionAndLogin.bean.PatientBean;
import com.virtualcare_registartionAndLogin.entity.PatientEntity;
import com.virtualcare_registartionAndLogin.repository.PatientRepository;
import com.virtualcare_registartionAndLogin.service.PatientService;
@Service
public class PatientServiceImplementation implements PatientService{
	@Autowired
	PatientRepository patientRepository;
	@Override
	public void save(PatientBean patientBean) {
		PatientEntity patientEntity=new PatientEntity();
		patientEntity.setPatient_id(patientBean.getPatient_id());
		patientEntity.setPatient_name(patientBean.getPatient_name());
		patientEntity.setPatient_age(patientBean.getPatient_age());
		patientEntity.setPatient_gender(patientBean.getPatient_gender());
		patientEntity.setPatient_password(patientBean.getPatient_password());
		patientEntity.setStatus(patientBean.getStatus());
		patientRepository.save(patientEntity);
		System.out.println("Patient Registered successfully");
	}
	@Override
	public String loginOrNot(Long patient_id, String patient_password) {
		Optional<PatientEntity> findByPatientId = patientRepository.findById(patient_id);
		if(findByPatientId.isPresent())
		{
			PatientEntity patientEntity1=findByPatientId.get();
			if(patientEntity1.getPatient_password().equals(patient_password))
			{
				return "Patient Logged in successfully";
			}
		}
		return "Please give valid login credentials";
	}
	

}
