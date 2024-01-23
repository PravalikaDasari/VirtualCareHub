package com.patient.services;


import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.bean.Patients;
import com.patient.repository.PatientsRepository;

import jakarta.transaction.Transactional;

/*import lombok.extern.slf4j.Slf4j;*/
@Transactional
@Service
public class PatientsServiceImpl implements  PatientService{
	@Autowired
	private PatientsRepository patientsRepository;
	@Override
	  public Patients save(Patients patients) {
        return patientsRepository.save(patients);
    }

	@Override
	public Patients get(Long id) {
		return patientsRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException(" Patient not found with id-" + id));
	}
	 
	@Override
	public void deletePatientById(Long id) {
		 Optional<Patients> patientOptional = patientsRepository.findById(id);

		    if (patientOptional.isPresent()) {
		        patientsRepository.deleteById(id);
		    } else {
		        throw new PatientNotFoundException("Patient not found with ID: " + id);
		    }}
		}
		
		
		
		
	

	


