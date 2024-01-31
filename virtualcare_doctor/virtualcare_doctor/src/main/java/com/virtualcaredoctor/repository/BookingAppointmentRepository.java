package com.virtualcaredoctor.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.virtualcaredoctor.bean.BookingAppointmentBean;
import com.virtualcaredoctor.entity.BookingAppointmentEntity;

import jakarta.transaction.Transactional;

@Transactional
public interface BookingAppointmentRepository extends JpaRepository<BookingAppointmentEntity, Long>{

	@Modifying
	@Query(value="update booking_appointment book set book.admit_status=:admitStatus where book.appointment_id=:appointmentId",nativeQuery = true)
	public void updateAdmitStatus(long appointmentId,String admitStatus) ;
	
	@Query(value="select * from booking_appointment book where book.appointment_date=:appointmentDate",nativeQuery = true)
	public List<BookingAppointmentEntity> getByAppointmentDate(Date appointmentDate);
}
