package com.patient.services;

import com.patient.bean.Patients;

public interface PatientService {

	 Patients save(Patients patients);

	Patients get(Long id);
	
	void deletePatientById(Long id);
}
