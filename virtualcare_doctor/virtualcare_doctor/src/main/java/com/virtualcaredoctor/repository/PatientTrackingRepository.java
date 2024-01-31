package com.virtualcaredoctor.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.virtualcaredoctor.entity.PatientTrackingEntity;

import jakarta.transaction.Transactional;
@Transactional
public interface PatientTrackingRepository extends JpaRepository<PatientTrackingEntity, Long>{

	@Modifying
	@Query(value="update patient_tracking track set track.test_name=:testName,track.date=:date where track.doctor_id=:doctorId and track.patient_phone=:patientId",nativeQuery = true)
	public void updatePatientTestName(long doctorId,long patientId,String testName,LocalDate date);

    @Query(value=" select * from patient_tracking track where track.doctor_id=:doctorId and track.patient_phone=:patientId",nativeQuery = true)
	public List<PatientTrackingEntity> findBydoctoridAndpatientphone(long doctorId,long patientId);
}
