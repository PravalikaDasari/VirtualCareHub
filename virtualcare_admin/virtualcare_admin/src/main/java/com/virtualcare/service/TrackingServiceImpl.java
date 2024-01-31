package com.virtualcare.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtualcare.bean.PatientTrackingBean;
import com.virtualcare.entity.PatientTrackingEntity;
import com.virtualcare.repository.TrackingRepository;
@Transactional
@Service
public class TrackingServiceImpl implements TrackingService{

	@Autowired
	private TrackingRepository repository;
	@Override
	public void updateTest(PatientTrackingBean bean) 
	{
		Long id = bean.getTrack_id();
		String test_status = bean.getTest_status();
		byte[] file = bean.getTest_report();
		String discharge_status = bean.getDischarge_status();
		repository.updateTestStatus(id,test_status,file,discharge_status);
	}

	@Override
	public List<PatientTrackingBean> fetchAll() 
	{
		List<PatientTrackingEntity> list = repository.findAll();
		return convertToEntity(list);
	}
	
	public  List<PatientTrackingBean> convertToEntity(List<PatientTrackingEntity> list)
	{
		List<PatientTrackingBean> beans = new ArrayList<>();
		for(PatientTrackingEntity entity : list)
		{
			PatientTrackingBean bean =  new PatientTrackingBean();
			
			bean.setTrack_id(entity.getTrack_id());
			bean.setTest_name(entity.getTest_name());
			bean.setDate(entity.getDate());
			bean.setDischarge_status(entity.getDischarge_status());
			bean.setPatient_phone(entity.getPatient_phone());
			bean.setTest_report(entity.getTest_report());
			bean.setTest_status(entity.getTest_status());
			bean.setDoctor_id(entity.getDoctor_id());
			beans.add(bean);
		}
		return beans;
	}

}
