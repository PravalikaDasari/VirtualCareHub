package com.virtualcaredoctor.service;

import java.util.List;

import com.virtualcaredoctor.bean.BookingAppointmentBean;

public interface BookingAppointmentService {

	public void saveAppointedPatient(BookingAppointmentBean bean);
    public List<BookingAppointmentBean> getByAppointmentDate(String appointmentDate);
	public void updateAdmitStatus(long appointmentId,String admitStatus) ;
    
}
