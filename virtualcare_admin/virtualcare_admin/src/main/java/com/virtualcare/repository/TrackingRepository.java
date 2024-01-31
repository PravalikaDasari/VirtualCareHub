package com.virtualcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.virtualcare.entity.PatientTrackingEntity;
@Transactional
public interface TrackingRepository extends JpaRepository<PatientTrackingEntity, Long> 
{
	@Modifying
	@Query(value = "update patient_tracking set test_status =:test_status,"
			+ "discharge_status=:discharge_status, test_report=:file where track_id=:id",nativeQuery = true)
	void updateTestStatus(Long id, String test_status, byte[] file, String discharge_status);

}
