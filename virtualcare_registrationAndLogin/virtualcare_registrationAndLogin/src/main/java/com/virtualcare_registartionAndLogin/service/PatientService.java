package com.virtualcare_registartionAndLogin.service;

import com.virtualcare_registartionAndLogin.bean.PatientBean;

public interface PatientService {
	public void save(PatientBean patientBean);
	public String loginOrNot(Long patient_id,String patient_password);
}
