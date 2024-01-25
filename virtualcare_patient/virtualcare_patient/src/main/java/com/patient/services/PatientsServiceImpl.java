package com.patient.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.bean.PatientsDto;
import com.patient.entity.Patients;
import com.patient.repository.PatientsRepository;

import jakarta.transaction.Transactional;

/*import lombok.extern.slf4j.Slf4j;*/
@Transactional
@Service
public class PatientsServiceImpl implements  PatientService{
	@Autowired
	private PatientsRepository patientsRepository;
	 
	PatientsDto patientsDto=new PatientsDto();
//	
//	 public Patients converting(PatientsDto patientsDto) {
//			
//			Patients  patients =new Patients();
//			patients.setId(patientsDto.getId());
//			patients.setName(patientsDto.getName());
//			patients.setGender(patientsDto.getGender());
//			patients.setAge(patientsDto.getAge());
//			patients.setPassword(patientsDto.getPassword());
//			patients.setStatus(patientsDto.getStatus());
//	        return patients;
//	    }
//	
//	
//	
	@Override
	  public void save(PatientsDto patientsDto) {
		
		Patients  patients =new Patients();
		patients.setId(patientsDto.getId());
		patients.setName(patientsDto.getName());
		patients.setGender(patientsDto.getGender());
		patients.setAge(patientsDto.getAge());
		patients.setPassword(patientsDto.getPassword());
		patients.setStatus(patientsDto.getStatus());
		
        patientsRepository.save(patients);
    }

	@Override
	public Patients get(Long id) {
	    Long dtoId = patientsDto.getId(); 
	    return patientsRepository.findById(dtoId).orElseThrow(
	            () -> new IllegalArgumentException("Patient not found with id-" + dtoId));
	}
	 
	@Override
	public void deletePatientById(Long id) {
		 Optional<Patients> patientOptional = patientsRepository.findById(id);

		    if (patientOptional.isPresent()) {
		        patientsRepository.deleteById(id);
		    } else {
		        throw new PatientNotFoundException("Patient not found with ID: " + id);
		    }}
	
	@Override
	public Optional<Patients> loginPatient(Long id, String password) {
		Optional<Patients> findByacc = patientsRepository.findById(id);
		if(findByacc.isPresent()) {
			Patients patientPass = findByacc.get();
			try{if(patientPass.getPassword().equals(password)) {

				    return patientsRepository.findById(id);
			}else throw new PatientNotFoundException("Wrong Password ");
		}catch(PatientNotFoundException e)
			{
			   System.out.println("Invalid password");
			   throw new PatientNotFoundException("Wrong Password ");
			}
			}else throw new PatientNotFoundException("Wrong Username ");
	}
		}
		
		
		
		
	

	


