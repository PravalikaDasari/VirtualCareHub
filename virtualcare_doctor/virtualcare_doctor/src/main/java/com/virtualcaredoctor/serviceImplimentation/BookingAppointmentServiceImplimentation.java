package com.virtualcaredoctor.serviceImplimentation;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualcaredoctor.bean.BookingAppointmentBean;
import com.virtualcaredoctor.entity.BookingAppointmentEntity;
import com.virtualcaredoctor.repository.BookingAppointmentRepository;
import com.virtualcaredoctor.service.BookingAppointmentService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookingAppointmentServiceImplimentation implements BookingAppointmentService{

	@Autowired
	BookingAppointmentRepository bookingAppointmentRepository;
	BookingAppointmentEntity entity=new BookingAppointmentEntity();

	@Override
	public void saveAppointedPatient(BookingAppointmentBean bean) {
		
		
		entity.setAppointment_id(bean.getAppointment_id());
		entity.setPatient_phone(bean.getPatient_phone());
		entity.setState_code(bean.getState_code());
		entity.setBranch_code(bean.getBranch_code());
		entity.setDoctor_speciality(bean.getDoctor_speciality());
		entity.setAppointment_id(bean.getAppointment_id());
		log.info("date{}",bean.getAppointment_date());
		entity.setAppointment_date(Date.valueOf(bean.getAppointment_date()));
		entity.setAppointment_time(bean.getAppointment_time());
		entity.setDoctor_id(bean.getDoctor_id());
		entity.setAdmit_status(bean.getAdmit_status());


		bookingAppointmentRepository.save(entity);
		log.info("inserted patient record {}"+entity);
		
	}

	@Override
	public void updateAdmitStatus(long appointment_id,String status) {

		//bookingAppointmentRepository.updateAdmitStatus(appointment_id, status);
//		BookingAppointmentBean bean = bookingAppointmentService.getById(appointment_id);
//		bean.setAdmit_status(status);
//		bookingAppointmentService.saveAppointedPatient(bean);
	}

	@SuppressWarnings("deprecation")
	@Override
	public BookingAppointmentBean getById(long appointment_id) {
		BookingAppointmentBean bean=new BookingAppointmentBean();
		bean.setAppointment_id(entity.getAppointment_id());
		BookingAppointmentEntity entity = bookingAppointmentRepository.getById(appointment_id);
            bean.setAppointment_id(entity.getAppointment_id());
            bean.setPatient_phone(entity.getPatient_phone());
            bean.setState_code(entity.getState_code());
            bean.setBranch_code(entity.getBranch_code());
            bean.setDoctor_speciality(entity.getDoctor_speciality());
            bean.setAppointment_id(entity.getAppointment_id());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
            String appointmentDate = dateFormat.format(entity.getAppointment_date());  
            bean.setAppointment_date(appointmentDate);
            bean.setAppointment_time(entity.getAppointment_time());
            bean.setDoctor_id(entity.getDoctor_id());
            bean.setAdmit_status(entity.getAdmit_status());

		return bean;
		
	}
	
	

}
