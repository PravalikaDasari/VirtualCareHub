package com.virtualcaredoctor.serviceImplimentation;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualcaredoctor.bean.PatientTrackingBean;
import com.virtualcaredoctor.entity.PatientTrackingEntity;
import com.virtualcaredoctor.repository.PatientTrackingRepository;
import com.virtualcaredoctor.service.PatientTrackingService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PatientTrackingServiceImplimentation implements PatientTrackingService {

	@Autowired
	PatientTrackingRepository patientTrackingRepository;

	public PatientTrackingBean convertEntityTobean(PatientTrackingEntity entity) {
		PatientTrackingBean bean = new PatientTrackingBean();
		bean.setTrack_id(entity.getTrack_id());
		bean.setTest_name(entity.getTest_name());
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		String appointmentDate = dateFormat.format(entity.getDate());
		bean.setDate(appointmentDate);
		bean.setDischarge_status(entity.getDischarge_status());
		bean.setDoctor_id(entity.getDoctor_id());
		bean.setPatient_phone(entity.getPatient_phone());
		bean.setTest_report(entity.getTest_report());
		bean.setTest_status(entity.getTest_status());
		return bean;
	}

	@Override
	public PatientTrackingBean getPatientTreatmentDetails(long trackId) {
		Optional<PatientTrackingEntity> findById = patientTrackingRepository.findById(trackId);
		PatientTrackingBean bean = convertEntityTobean(findById.get());
		return bean;
	}

	public PatientTrackingEntity convertBeanToEntity(PatientTrackingBean bean) {
		PatientTrackingEntity entity=new PatientTrackingEntity();
		entity.setTrack_id(bean.getTrack_id());
		entity.setPatient_phone(bean.getPatient_phone());
		entity.setDischarge_status(bean.getDischarge_status());
		entity.setDoctor_id(bean.getDoctor_id());
		entity.setTest_name(bean.getTest_name());
		entity.setTest_report(bean.getTest_report());
		entity.setDate(Date.valueOf(bean.getDate()));
		entity.setTest_status(bean.getTest_status());
		
		return entity;
	}
	@Override
	public void savePatientTrackRecord(PatientTrackingEntity entity) {
		patientTrackingRepository.save(entity);
		log.info(" patient track inserted");
	}

	@Override
	public void updatePatientTestName(long doctorId, long patientId, String testName) {
		LocalDate localDate = java.time.LocalDate.now();
		patientTrackingRepository.updatePatientTestName(doctorId, patientId, testName, localDate);
		
	}

	@Override
	public List<PatientTrackingBean> getByDoctorIdAndPatientId(long doctorId, long patientId) {
			List<PatientTrackingBean> beans=new ArrayList<>();
			List<PatientTrackingEntity> findBydoctor_idAndpatient_phone = patientTrackingRepository.findBydoctoridAndpatientphone(doctorId, patientId);
			for (PatientTrackingEntity patientTrackingEntity : findBydoctor_idAndpatient_phone) {
				PatientTrackingBean convertEntityTobean = convertEntityTobean(patientTrackingEntity);
				beans.add(convertEntityTobean);
			}
			return beans;
		}

	


	
	

}
