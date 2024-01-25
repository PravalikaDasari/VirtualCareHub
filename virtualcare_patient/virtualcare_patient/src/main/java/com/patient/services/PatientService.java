package com.patient.services;

import java.util.Optional;

import com.patient.bean.PatientsDto;
import com.patient.entity.Patients;

public interface PatientService {

	 void save(PatientsDto patientsDto);

	 Patients get(Long id);
	
	void deletePatientById(Long id) throws PatientNotFoundException;
	
	Optional<Patients> loginPatient(Long id, String password) throws PatientNotFoundException;
}
