package com.virtualcare_registartionAndLogin.service;

import com.virtualcare_registartionAndLogin.bean.DoctorBean;

public interface DoctorService {
	public void save(DoctorBean doctorBean);
	public String loginDoctor(Long doctor_id,String doctor_password);
}
