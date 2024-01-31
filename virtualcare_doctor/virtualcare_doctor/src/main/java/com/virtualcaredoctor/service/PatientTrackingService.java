package com.virtualcaredoctor.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.virtualcaredoctor.bean.PatientTrackingBean;
import com.virtualcaredoctor.entity.PatientTrackingEntity;

public interface PatientTrackingService {

    public PatientTrackingBean getPatientTreatmentDetails(long trackId);

    public  void savePatientTrackRecord(PatientTrackingEntity bean);
	public void updatePatientTestName(long doctorId,long patientId,String testName);
	
	public List<PatientTrackingBean> getByDoctorIdAndPatientId(long doctorId,long patientId);

}
