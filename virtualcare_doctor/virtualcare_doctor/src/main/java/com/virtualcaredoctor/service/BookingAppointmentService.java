package com.virtualcaredoctor.service;

import com.virtualcaredoctor.bean.BookingAppointmentBean;

public interface BookingAppointmentService {

	public void saveAppointedPatient(BookingAppointmentBean bean);
	public void updateAdmitStatus(long appointmentId,String status);
	public BookingAppointmentBean getById(long appointment_id);
}
