package com.virtualcaredoctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.virtualcaredoctor.entity.BookingAppointmentEntity;


public interface BookingAppointmentRepository extends JpaRepository<BookingAppointmentEntity, Long>{

	@Query(value="update booking_appointment book set book.admit_status=:status where book.appointment_id=:appointment_id",nativeQuery = true)
	public void updateAdmitStatus(long appointment_id,String status);
	

}
